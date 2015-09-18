package dzn.teamjava.dao;

import dzn.teamjava.model.TagPhoto;

public interface TagPhotoMapper {
    int insert(TagPhoto record);

    int insertSelective(TagPhoto record);
}