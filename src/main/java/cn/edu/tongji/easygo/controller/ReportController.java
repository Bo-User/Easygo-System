package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.dto.ReportVo;
import cn.edu.tongji.easygo.model.Report;
import cn.edu.tongji.easygo.service.ReportService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin
@Api(value = "举报", tags = "举报", description = "举报")
public class ReportController {
    @Autowired
    ReportService reportService;

    @ApiOperation("添加举报")
    @PostMapping("")
    public Result addReport(@RequestBody ReportVo reportVo) {
        Report report = new Report();
        report.setReportStatus(false);//未审核
        report.setReportThingId(reportVo.getReportThingId());
        report.setReportReason(reportVo.getReportReason());
        report.setReportType(reportVo.getReportType());
        report.setReportUserId(reportVo.getReportUserId());
        reportService.addReport(report);
        return Result.wrapSuccessfulResult("添加成功");
    }

    @ApiOperation("查看某举报")
    @GetMapping("{reportId}")
    public Result showReport(@PathVariable Long reportId) {
        Report report = reportService.showConcreteReport(reportId);
        return Result.wrapSuccessfulResult(report);
    }

    @ApiOperation("查看待处理（status为0）举报列表")
    @GetMapping("status")
    public Result showHandleList() {
        List<Report> reports = reportService.findReportByStatus(false);
        return Result.wrapSuccessfulResult(reports);
    }

    @ApiOperation("查看指定类型（信息为0，评论为1）举报列表")
    @GetMapping("type/{reportType}")
    public Result showHandleList(@PathVariable("reportType") int reportType) {
        List<Report> reports = reportService.findReportByType(reportType);
        return Result.wrapSuccessfulResult(reports);
    }

    @ApiOperation("查询所有举报信息")
    @GetMapping("")
    public Result showReports() {
        List<Report> reports = reportService.findAllReport();
        return Result.wrapSuccessfulResult(reports);
    }

    @ApiOperation("删除举报信息")
    @DeleteMapping("{reportId}")
    public Result deleteReport(@PathVariable Long reportId) {
        reportService.deleteReport(reportId);
        return Result.wrapSuccessfulResult("删除成功");
    }

    @ApiOperation("修改举报信息")
    @PutMapping("{reportId}")
    public Result updateReport(@PathVariable("reportId") Long reportId, @RequestBody Report report) {
        reportService.updateReport(reportId, report);
        return Result.wrapSuccessfulResult("修改成功");
    }
}