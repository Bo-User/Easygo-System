package cn.edu.tongji.easygo.model;/*
    @Created by Jary-Li on 2022/1/7. All rights reserved.
    @Name: easygo
    @Description：
*/

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
public class Report {
    private long reportId;
    private long reportUserId;
    private long reportThingId;
    private int reportType;
    private String reportReason;
    private boolean reportStatus;
    private Timestamp reportTime;
    private String reportResult;
    private Long reportDealerId;
    private Timestamp reportDealTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "report_user_id")
    public long getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(long reportUserId) {
        this.reportUserId = reportUserId;
    }

    @Basic
    @Column(name = "report_thing_id")
    public long getReportThingId() {
        return reportThingId;
    }

    public void setReportThingId(long reportThingId) {
        this.reportThingId = reportThingId;
    }

    @Basic
    @Column(name = "report_type")
    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    @Basic
    @Column(name = "report_reason")
    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    @Basic
    @Column(name = "report_status")
    public boolean isReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Basic
    @Column(name = "report_time")
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "report_result")
    public String getReportResult() {
        return reportResult;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult;
    }

    @Basic
    @Column(name = "report_dealer_id")
    public Long getReportDealerId() {
        return reportDealerId;
    }

    public void setReportDealerId(Long reportDealerId) {
        this.reportDealerId = reportDealerId;
    }

    @Basic
    @Column(name = "report_deal_time")
    public Timestamp getReportDealTime() {
        return reportDealTime;
    }

    public void setReportDealTime(Timestamp reportDealTime) {
        this.reportDealTime = reportDealTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return reportId == report.reportId && reportUserId == report.reportUserId && reportThingId == report.reportThingId && reportType == report.reportType && reportStatus == report.reportStatus && Objects.equals(reportReason, report.reportReason) && Objects.equals(reportTime, report.reportTime) && Objects.equals(reportResult, report.reportResult) && Objects.equals(reportDealerId, report.reportDealerId) && Objects.equals(reportDealTime, report.reportDealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reportUserId, reportThingId, reportType, reportReason, reportStatus, reportTime, reportResult, reportDealerId, reportDealTime);
    }
}
