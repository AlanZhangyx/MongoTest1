package dzn.teamjava.model;

import java.util.Date;

public class Comment {
    private Long commentId;

    private Long userId;

    private Long photoId;

    private Short commentType;

    private String comment;

    private String audioGroup;

    private String audioFile;

    private Date createTime;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Short getCommentType() {
        return commentType;
    }

    public void setCommentType(Short commentType) {
        this.commentType = commentType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getAudioGroup() {
        return audioGroup;
    }

    public void setAudioGroup(String audioGroup) {
        this.audioGroup = audioGroup == null ? null : audioGroup.trim();
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile == null ? null : audioFile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}