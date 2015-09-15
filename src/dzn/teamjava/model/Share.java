package dzn.teamjava.model;

import java.util.Date;

public class Share {
    private Long xxShareId;

    private Long userId;

    private Double centerLng;

    private Double centerLat;

    private Short zoom;

    private String checkCode;

    private Date createTime;

    public Long getXxShareId() {
        return xxShareId;
    }

    public void setXxShareId(Long xxShareId) {
        this.xxShareId = xxShareId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getCenterLng() {
        return centerLng;
    }

    public void setCenterLng(Double centerLng) {
        this.centerLng = centerLng;
    }

    public Double getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(Double centerLat) {
        this.centerLat = centerLat;
    }

    public Short getZoom() {
        return zoom;
    }

    public void setZoom(Short zoom) {
        this.zoom = zoom;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode == null ? null : checkCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}