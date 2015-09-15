package dzn.teamjava.model;

import java.util.Date;

public class PhotoStatistic {
    private Long xxPhotosStatisticsId;

    private Long userId;

    private Long photosNum;

    private Date firstTime;

    private Date latestTime;

    public Long getXxPhotosStatisticsId() {
        return xxPhotosStatisticsId;
    }

    public void setXxPhotosStatisticsId(Long xxPhotosStatisticsId) {
        this.xxPhotosStatisticsId = xxPhotosStatisticsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhotosNum() {
        return photosNum;
    }

    public void setPhotosNum(Long photosNum) {
        this.photosNum = photosNum;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }
}