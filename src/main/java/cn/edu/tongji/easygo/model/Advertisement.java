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
public class Advertisement {
    private long advertisementId;
    private Timestamp advertisementTime;
    private String advertisementUrl;
    private String advertisementTitle;
    private Integer advertisementState;
    private String advertisementImage;

    @Id
    @Column(name = "advertisement_id")
    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Basic
    @Column(name = "advertisement_time")
    public Timestamp getAdvertisementTime() {
        return advertisementTime;
    }

    public void setAdvertisementTime(Timestamp advertisementTime) {
        this.advertisementTime = advertisementTime;
    }

    @Basic
    @Column(name = "advertisement_url")
    public String getAdvertisementUrl() {
        return advertisementUrl;
    }

    public void setAdvertisementUrl(String advertisementUrl) {
        this.advertisementUrl = advertisementUrl;
    }

    @Basic
    @Column(name = "advertisement_title")
    public String getAdvertisementTitle() {
        return advertisementTitle;
    }

    public void setAdvertisementTitle(String advertisementTitle) {
        this.advertisementTitle = advertisementTitle;
    }

    @Basic
    @Column(name = "advertisement_state")
    public Integer getAdvertisementState() {
        return advertisementState;
    }

    public void setAdvertisementState(Integer advertisementState) {
        this.advertisementState = advertisementState;
    }

    @Basic
    @Column(name = "advertisement_image")
    public String getAdvertisementImage() {
        return advertisementImage;
    }

    public void setAdvertisementImage(String advertisementImage) {
        this.advertisementImage = advertisementImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return advertisementId == that.advertisementId &&
                Objects.equals(advertisementTime, that.advertisementTime) &&
                Objects.equals(advertisementUrl, that.advertisementUrl) &&
                Objects.equals(advertisementTitle, that.advertisementTitle) &&
                Objects.equals(advertisementState, that.advertisementState) &&
                Objects.equals(advertisementImage, that.advertisementImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisementId, advertisementTime, advertisementUrl, advertisementTitle, advertisementState, advertisementImage);
    }
}
