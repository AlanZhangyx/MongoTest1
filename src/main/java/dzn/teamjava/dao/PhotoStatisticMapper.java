package dzn.teamjava.dao;

import dzn.teamjava.model.PhotoStatistic;

public interface PhotoStatisticMapper {
    int deleteByPrimaryKey(Long xxPhotosStatisticsId);

    int insert(PhotoStatistic record);

    int insertSelective(PhotoStatistic record);

    PhotoStatistic selectByPrimaryKey(Long xxPhotosStatisticsId);

    int updateByPrimaryKeySelective(PhotoStatistic record);

    int updateByPrimaryKey(PhotoStatistic record);
}