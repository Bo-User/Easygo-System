package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
public class Information {
    private long informationId;
    private String informationDescription;
    private long informationUserId;
    private int informationType;
    private Timestamp informationDeadline;
    private double informationPrice;
    private String informationName;
    private Timestamp informationTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_id")
    public long getInformationId() {
        return informationId;
    }

    public void setInformationId(long informationId) {
        this.informationId = informationId;
    }

    @Basic
    @Column(name = "information_description")
    public String getInformationDescription() {
        return informationDescription;
    }

    public void setInformationDescription(String informationDescription) {
        this.informationDescription = informationDescription;
    }

    @Basic
    @Column(name = "information_user_id")
    public long getInformationUserId() {
        return informationUserId;
    }

    public void setInformationUserId(long informationUserId) {
        this.informationUserId = informationUserId;
    }

    @Basic
    @Column(name = "information_type")
    public int getInformationType() {
        return informationType;
    }

    public void setInformationType(int informationType) {
        this.informationType = informationType;
    }

    @Basic
    @Column(name = "information_deadline")
    public Timestamp getInformationDeadline() {
        return informationDeadline;
    }

    public void setInformationDeadline(Timestamp informationDeadline) {
        this.informationDeadline = informationDeadline;
    }

    @Basic
    @Column(name = "information_price")
    public double getInformationPrice() {
        return informationPrice;
    }

    public void setInformationPrice(double informationPrice) {
        this.informationPrice = informationPrice;
    }

    @Basic
    @Column(name = "information_name")
    public String getInformationName() {
        return informationName;
    }

    public void setInformationName(String informationName) {
        this.informationName = informationName;
    }

    @Basic
    @Column(name = "information_time")
    public Timestamp getInformationTime() {
        return informationTime;
    }

    public void setInformationTime(Timestamp informationTime) {
        this.informationTime = informationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return informationId == that.informationId && informationUserId == that.informationUserId && informationType == that.informationType && Double.compare(that.informationPrice, informationPrice) == 0 && Objects.equals(informationDescription, that.informationDescription) && Objects.equals(informationDeadline, that.informationDeadline) && Objects.equals(informationName, that.informationName) && Objects.equals(informationTime, that.informationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informationId, informationDescription, informationUserId, informationType, informationDeadline, informationPrice, informationName, informationTime);
    }
}
