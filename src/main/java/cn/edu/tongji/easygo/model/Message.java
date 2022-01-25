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
public class Message {
    private long messageId;
    private long messageUserId;
    private Long messageReportId;
    private String messageContent;
    private Timestamp messageTime;
    private boolean messageRead;
    private String messageTitle;
    private Long messageSenderId;

    @Id
    @Column(name = "message_id")
    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "message_user_id")
    public long getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(long messageUserId) {
        this.messageUserId = messageUserId;
    }

    @Basic
    @Column(name = "message_report_id")
    public Long getMessageReportId() {
        return messageReportId;
    }

    public void setMessageReportId(Long messageReportId) {
        this.messageReportId = messageReportId;
    }

    @Basic
    @Column(name = "message_content")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "message_time")
    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    @Basic
    @Column(name = "message_read")
    public boolean isMessageRead() {
        return messageRead;
    }

    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }

    @Basic
    @Column(name = "message_title")
    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    @Basic
    @Column(name = "message_sender_id")
    public Long getMessageSenderId() {
        return messageSenderId;
    }

    public void setMessageSenderId(Long messageSenderId) {
        this.messageSenderId = messageSenderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId && messageUserId == message.messageUserId && messageRead == message.messageRead && Objects.equals(messageReportId, message.messageReportId) && Objects.equals(messageContent, message.messageContent) && Objects.equals(messageTime, message.messageTime) && Objects.equals(messageTitle, message.messageTitle) && Objects.equals(messageSenderId, message.messageSenderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageUserId, messageReportId, messageContent, messageTime, messageRead, messageTitle, messageSenderId);
    }
}
