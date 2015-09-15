package dzn.teamjava.dao;

import dzn.teamjava.model.SharePhoto;

public interface SharePhotoMapper {
    int insert(SharePhoto record);

    int insertSelective(SharePhoto record);
}