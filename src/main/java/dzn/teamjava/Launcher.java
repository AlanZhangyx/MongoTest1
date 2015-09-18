package dzn.teamjava;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import dzn.teamjava.model.Photo;
import dzn.teamjava.util.NormalUtil;

public class Launcher {
    
    //mongodb://[username:password@]host1[:port1][,host2[:port2],…[,hostN[:portN]]][/[database][?options]]
    private static String sURI = String.format("mongodb://%s:%s@%s:%d/%s", "user_test", "12345678", "127.0.0.1", 27017, "db_thz"); 
    private static MongoClientURI uri=null;
    private static MongoClient mongoClient = null;
    private static MongoDatabase db=null;
    
    @Before
    public void initClient(){
        uri = new MongoClientURI(sURI); 
        mongoClient = new MongoClient(uri); 
        db = mongoClient.getDatabase("db_thz");
    }
    
    
    @Test
    public void inserts() throws IOException{
        //将数据库中全部数据取出
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        Map<String,Object> map=new HashMap<String,Object>();//条件
        List<Photo> tempList =session.selectList("dzn.teamjava.dao.PhotoMapper.checkoutPhotos",map);
        
        //the client configuration
        //PhotoMapper photoMapper=session.getMapper(PhotoMapper.class);
        long count=(Long)session.selectOne("dzn.teamjava.dao.PhotoMapper.photoCount");
        if (count<1) {
            return;
        }
        
        //构造数据
        MongoCollection<Document> collection=db.getCollection("xx_photos");
        long times=0;
        while (times<10000) {//100K次,总共插入401500000条
            times++;
            List<Document> dList=ObjList222DocList(tempList);
            collection.insertMany(dList);
            System.out.println("第"+times+"次插入数据，数量："+dList.size());
        }
        //关闭资源
        mongoClient.close();
    }
    
    
    
    @Test
    public void readOne() throws IOException, ParseException{
        MongoCollection<Document> collection=db.getCollection("xx_photos");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        
        BasicDBObject params=new BasicDBObject();
        params.append("userId", 596);
        params.append("exPhotoTime", new BasicDBObject("$gte",sdf.parse("2015-09-06")));
        params.append("exPhotoTime", new BasicDBObject("$lte",sdf.parse("2015-09-07")));
        
        System.err.println("开始时间："+System.currentTimeMillis());
        FindIterable<Document> itera=collection.find(params);
        System.err.println("结束时间："+System.currentTimeMillis());
        
        MongoCursor<Document> mc=itera.iterator();
        Document doc=null;
        StringBuilder sb=new StringBuilder();
        while (mc.hasNext()) {
            doc= mc.tryNext();
            String s= sdf.format(doc.getDate("exPhotoTime"));
            System.out.println(s);
            sb.append(doc.toJson());
        }
        Writer writer=new FileWriter(new File("D:\\1.json"));
        writer.write(sb.toString());
        writer.close();
    }
    
    @Test
    public void readTest() throws IOException{
        MongoCollection<Document> collection=db.getCollection("xx_photos");
        FindIterable<Document> itera=collection.find();
        MongoCursor<Document> mc=itera.iterator();
        Document doc=null;
        StringBuilder sb=new StringBuilder();
        while (mc.hasNext()) {
            doc= mc.tryNext();
            
            sb.append(doc.toJson());
        }
        Writer writer=new FileWriter(new File("D:\\1.json"));
        writer.write(sb.toString());
        writer.close();
    }
    
    
    @Test
    public void mySql2Mongo() throws IOException{
        //the system configuration
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        
        //the client configuration 
        //PhotoMapper photoMapper=session.getMapper(PhotoMapper.class);
        long count=(Long)session.selectOne("dzn.teamjava.dao.PhotoMapper.photoCount");
        if (count<1) {
            return;
        }
        
        MongoCollection<Document> collection=db.getCollection("xx_photos");
        long times=count/100;//次数
        Map<String,Object> map=new HashMap<String,Object>();//条件
        int limit=1000;
        map.put("limit", limit);
        for (int i = 0,offset=0; i < times+1; i++,offset+=limit) {
            map.put("offset", offset);
            List<Photo> tempList =session.selectList("dzn.teamjava.dao.PhotoMapper.checkoutPhotos",map);
            List<Document> dList=ObjList2DocList(tempList);
            
            collection.insertMany(dList);
            System.out.println("第"+(i+1)+"次插入数据，数量："+dList.size());
        }
        //关闭资源
        mongoClient.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws Exception {
        MongoCollection<Document> collection=db.getCollection("xx_photos");
        
        //关闭资源
        mongoClient.close();
    }
    
    @SuppressWarnings("unchecked")
    private static List<Document> ObjList2DocList(List<Photo> list) {
        List<Document> dList=new ArrayList<Document>();
        Document doc=null;
        for (int i = 0; i < list.size(); i++) {
            doc=new Document();
            //1 Bean 转 Document
            beanToDocument(list.get(i),doc);
            //2 将shareIds,tagIds构造为数组
            List<Long> shareIdsList=(List<Long>)doc.get("shareIds");
            List<Long> tagIdsList=(List<Long>)doc.get("tagIds");
            if (shareIdsList.size()>0) {
                StringBuilder sb=new StringBuilder("[");
                for (Long long1 : shareIdsList) {
                    sb.append(long1).append(",");
                }
                doc.put("shareIds",sb.substring(0, sb.length()-1)+"]");
            }else {
                doc.put("shareIds", "[]");
            }
            if (tagIdsList.size()>0) {
                StringBuilder sb=new StringBuilder("[");
                for (Long long1 : tagIdsList) {
                    sb.append(long1).append(",");
                }
                doc.put("tagIds",sb.substring(0, sb.length()-1)+"]");
            }else {
                doc.put("tagIds", "[]");
            }
            dList.add(doc);
        }
        return dList;
    }

    //将javabean转为map类型，然后返回一个map类型的值
    public static void beanToMap(Object obj,Map<String,Object> params) { 
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!StringUtils.equals(name, "class")) {
                    Object property=propertyUtilsBean.getNestedProperty(obj, name);
                    if (null!=property) {
                        params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                    }else{
                        params.put(name, "");
                    }
                } 
            } 
        } catch (Exception e) { 
          e.printStackTrace(); 
        } 
    }
    
    //将javabean转为map类型，然后返回一个map类型的值
    public static void beanToDocument(Object obj,Document params) { 
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!StringUtils.equals(name, "class")) {
                    Object property=propertyUtilsBean.getNestedProperty(obj, name);
                    if (null!=property) {
                        params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                    }else{
                        params.put(name, "");
                    }
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    
    /////////////////构造测试数据   
    @SuppressWarnings("unchecked")
    private static List<Document> ObjList222DocList(List<Photo> list) {
        List<Document> dList=new ArrayList<Document>();
        Document doc=null;
        for (int i = 0; i < list.size(); i++) {
            //随机一些参数
            Photo p=list.get(i);
            p.setGeoNum(RandomUtils.nextLong());
            p.setExPhotoTime(NormalUtil.randomDate("2008-01-01", "2015-09-11"));
            p.setPhotoId(RandomUtils.nextLong());
            
            doc=new Document();
            //1 Bean 转 Document
            beanToDocument(p,doc);
            //2 将shareIds,tagIds构造为数组
            List<Long> shareIdsList=(List<Long>)doc.get("shareIds");
            List<Long> tagIdsList=(List<Long>)doc.get("tagIds");
            if (shareIdsList.size()>0) {
                StringBuilder sb=new StringBuilder("[");
                for (Long long1 : shareIdsList) {
                    sb.append(long1).append(",");
                }
                doc.put("shareIds",sb.substring(0, sb.length()-1)+"]");
            }else {
                doc.put("shareIds", "[]");
            }
            if (tagIdsList.size()>0) {
                StringBuilder sb=new StringBuilder("[");
                for (Long long1 : tagIdsList) {
                    sb.append(long1).append(",");
                }
                doc.put("tagIds",sb.substring(0, sb.length()-1)+"]");
            }else {
                doc.put("tagIds", "[]");
            }
            dList.add(doc);
        }
        return dList;
    }
    
}
