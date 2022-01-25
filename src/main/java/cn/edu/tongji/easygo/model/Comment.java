package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
public class Comment {
    private long commentId;
    private long commentBelongId;
    private Timestamp commentTime;
    private long commentUserId;
    private String commentContent;
    private double commentRate;

    @Id
    @Column(name = "comment_id")
    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "comment_belong_id")
    public long getCommentBelongId() {
        return commentBelongId;
    }

    public void setCommentBelongId(long commentBelongId) {
        this.commentBelongId = commentBelongId;
    }

    @Basic
    @Column(name = "comment_time")
    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    @Basic
    @Column(name = "comment_user_id")
    public long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(long commentUserId) {
        this.commentUserId = commentUserId;
    }

    @Basic
    @Column(name = "comment_content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "comment_rate")
    public double getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(double commentRate) {
        this.commentRate = commentRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId && commentBelongId == comment.commentBelongId && commentUserId == comment.commentUserId && Double.compare(comment.commentRate, commentRate) == 0 && Objects.equals(commentTime, comment.commentTime) && Objects.equals(commentContent, comment.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentBelongId, commentTime, commentUserId, commentContent, commentRate);
    }
}
