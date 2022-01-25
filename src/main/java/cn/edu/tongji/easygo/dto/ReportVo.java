package cn.edu.tongji.easygo.dto;

import lombok.Data;

@Data
public class ReportVo {
    private long reportUserId;
    private long reportThingId;
    private Integer reportType;
    private String reportReason;
}
