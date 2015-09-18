package dzn.teamjava.model;

import java.util.Date;

public class Tag {
    private Long xxTagId;

    private Long userId;

    private String tagName;

    private Integer useNum;

    private Integer photoNum;

    private Date createTime;

    public Long getXxTagId() {
        return xxTagId;
    }

    public void setXxTagId(Long xxTagId) {
        this.xxTagId = xxTagId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Integer getPhotoNum() {
        return photoNum;
    }

    public void setPhotoNum(Integer photoNum) {
        this.photoNum = photoNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}