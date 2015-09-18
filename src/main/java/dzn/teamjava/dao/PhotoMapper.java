package dzn.teamjava.dao;

import dzn.teamjava.model.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Long photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Long photoId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}