package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    Report addReport(Report report);

    Report showConcreteReport(Long reportId);

    List<Report> findReportByType(int i);

    List<Report> findAllReport();

    void deleteReport(Long reportId);

    void updateReport(Long reportId, Report report);

    List<Report> findReportByStatus(Boolean isDeal);
}
