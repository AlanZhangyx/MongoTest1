package dzn.teamjava.dao;

import dzn.teamjava.model.Tag;

public interface TagMapper {
    int deleteByPrimaryKey(Long xxTagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long xxTagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}