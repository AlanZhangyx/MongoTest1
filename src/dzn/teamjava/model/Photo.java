package dzn.teamjava.model;

import java.util.Date;
import java.util.List;

public class Photo {
    private Long photoId;

    private Long userId;

    private String imgResGroup;

    private String imgResFile;

    private String imgThumb00Group;

    private String imgThumb00File;

    private String imgThumb01Group;

    private String imgThumb01File;

    private String imgThumb02Group;

    private String imgThumb02File;

    private Long geoNum;

    private Short geoLevel;

    private String iwcode;

    private Float lng;

    private Float lat;

    private Date exPhotoTime;

    private String exCountry;

    private String exProvince;

    private String exCity;

    private String exDistrict;

    private String exAddress;

    private String exif;

    private String remark;

    private Integer praiseNum;

    private Integer commentNum;

    private Boolean delFlag;

    private Date createTime;
    
    private List<Long> shareIds;
    
    private List<Long> tagIds;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgResGroup() {
        return imgResGroup;
    }

    public void setImgResGroup(String imgResGroup) {
        this.imgResGroup = imgResGroup == null ? null : imgResGroup.trim();
    }

    public String getImgResFile() {
        return imgResFile;
    }

    public void setImgResFile(String imgResFile) {
        this.imgResFile = imgResFile == null ? null : imgResFile.trim();
    }

    public String getImgThumb00Group() {
        return imgThumb00Group;
    }

    public void setImgThumb00Group(String imgThumb00Group) {
        this.imgThumb00Group = imgThumb00Group == null ? null : imgThumb00Group.trim();
    }

    public String getImgThumb00File() {
        return imgThumb00File;
    }

    public void setImgThumb00File(String imgThumb00File) {
        this.imgThumb00File = imgThumb00File == null ? null : imgThumb00File.trim();
    }

    public String getImgThumb01Group() {
        return imgThumb01Group;
    }

    public void setImgThumb01Group(String imgThumb01Group) {
        this.imgThumb01Group = imgThumb01Group == null ? null : imgThumb01Group.trim();
    }

    public String getImgThumb01File() {
        return imgThumb01File;
    }

    public void setImgThumb01File(String imgThumb01File) {
        this.imgThumb01File = imgThumb01File == null ? null : imgThumb01File.trim();
    }

    public String getImgThumb02Group() {
        return imgThumb02Group;
    }

    public void setImgThumb02Group(String imgThumb02Group) {
        this.imgThumb02Group = imgThumb02Group == null ? null : imgThumb02Group.trim();
    }

    public String getImgThumb02File() {
        return imgThumb02File;
    }

    public void setImgThumb02File(String imgThumb02File) {
        this.imgThumb02File = imgThumb02File == null ? null : imgThumb02File.trim();
    }

    public Long getGeoNum() {
        return geoNum;
    }

    public void setGeoNum(Long geoNum) {
        this.geoNum = geoNum;
    }

    public Short getGeoLevel() {
        return geoLevel;
    }

    public void setGeoLevel(Short geoLevel) {
        this.geoLevel = geoLevel;
    }

    public String getIwcode() {
        return iwcode;
    }

    public void setIwcode(String iwcode) {
        this.iwcode = iwcode == null ? null : iwcode.trim();
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Date getExPhotoTime() {
        return exPhotoTime;
    }

    public void setExPhotoTime(Date exPhotoTime) {
        this.exPhotoTime = exPhotoTime;
    }

    public String getExCountry() {
        return exCountry;
    }

    public void setExCountry(String exCountry) {
        this.exCountry = exCountry == null ? null : exCountry.trim();
    }

    public String getExProvince() {
        return exProvince;
    }

    public void setExProvince(String exProvince) {
        this.exProvince = exProvince == null ? null : exProvince.trim();
    }

    public String getExCity() {
        return exCity;
    }

    public void setExCity(String exCity) {
        this.exCity = exCity == null ? null : exCity.trim();
    }

    public String getExDistrict() {
        return exDistrict;
    }

    public void setExDistrict(String exDistrict) {
        this.exDistrict = exDistrict == null ? null : exDistrict.trim();
    }

    public String getExAddress() {
        return exAddress;
    }

    public void setExAddress(String exAddress) {
        this.exAddress = exAddress == null ? null : exAddress.trim();
    }

    public String getExif() {
        return exif;
    }

    public void setExif(String exif) {
        this.exif = exif == null ? null : exif.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Long> getShareIds() {
        return shareIds;
    }

    public void setShareIds(List<Long> shareIds) {
        this.shareIds = shareIds;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}