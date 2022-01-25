package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Report;
import cn.edu.tongji.easygo.repository.ReportRepository;
import cn.edu.tongji.easygo.service.ReportService;
import cn.edu.tongji.easygo.util.JpaUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    ReportRepository reportRepository;

    @Override
    public Report addReport(Report report) {
        return (reportRepository.save(report));
    }

    @Override
    public Report showConcreteReport(Long reportId) {
        return reportRepository.findReportByReportId(reportId);
    }

    @Override
    public List<Report> findReportByType(int i) {
        return reportRepository.findReportsByReportType(i);
    }

    @Override
    public List<Report> findAllReport() {
        List<Report> all = reportRepository.findAll();
        return all;
    }

    @Override
    public void deleteReport(Long reportId) {
        reportRepository.deleteReportByReportId(reportId);
    }

    @Override
    public void updateReport(Long reportId, Report report) {
        Report reportByReportId = reportRepository.findReportByReportId(reportId);
        JpaUtil.copyNotNullProperties(report,reportByReportId);
        reportRepository.save(reportByReportId);
    }

    @Override
    public List<Report> findReportByStatus(Boolean isDeal) {
        return reportRepository.findReportsByReportStatus(isDeal);
    }
}
