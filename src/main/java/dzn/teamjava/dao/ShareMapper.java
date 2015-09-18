package dzn.teamjava.dao;

import dzn.teamjava.model.Share;

public interface ShareMapper {
    int deleteByPrimaryKey(Long xxShareId);

    int insert(Share record);

    int insertSelective(Share record);

    Share selectByPrimaryKey(Long xxShareId);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}