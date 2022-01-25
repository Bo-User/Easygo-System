package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Transactional
    void deleteReportByReportId(Long reportId);

    Report findReportByReportId(Long reportId);

    List<Report> findReportsByReportType(int type);

    List<Report> findReportsByReportStatus(Boolean isDeal);
}
