package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Information;
import cn.edu.tongji.easygo.service.InformationService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("api/v1/information")
@RestController
@CrossOrigin
@Api(value = "需求和物品", tags = "需求和物品", description = "需求和物品")
public class InformationController {

    @Resource
    InformationService informationService;

    @ApiOperation("所有需求")
    @GetMapping ("")
    public Result getAllInformation(@RequestParam("size") int size,@RequestParam("page") int page) {

        return Result.wrapSuccessfulResult(informationService.findAllInformation(page,size));
    }

    @ApiOperation("添加需求/物品")
    @PostMapping("")
    public Result addInformation(@RequestBody Information information) {
        return Result.wrapSuccessfulResult(informationService.addInformation(information));
    }

    @ApiOperation("删除某需求/物品")
    @DeleteMapping("{informationId}")
    public Result deleteInformation(@PathVariable("informationId") Long informationId) {
        informationService.deleteInformation(informationId);
        return Result.wrapSuccessfulResult("删除成功");
    }

    @ApiOperation("查询某需求/物品信息")
    @GetMapping("{informationId}")
    public Result showInformation(@PathVariable("informationId") Long informationId) {
        return Result.wrapSuccessfulResult(informationService.showInformation(informationId));
    }

    @ApiOperation("修改某需求/物品信息")
    @PutMapping("{informationId}")
    public Result updateInformation(@PathVariable("informationId") Long informationId, @RequestBody Information information) {
        try {
            informationService.updateInformation(informationId, information);
            return Result.wrapSuccessfulResult("修改成功");
        } catch (Exception e) {
            return Result.wrapErrorResult("修改失败");
        }
    }

    @ApiOperation("查询需求/物品信息列表")
    @GetMapping("/type/{informationType}")
    public Result showInformationByType(@PathVariable Integer informationType) {
        List<Information> informationList = informationService.findInformationByType(informationType);
        return Result.wrapSuccessfulResult(informationList);
    }

    @ApiOperation("查询某用户的需求和物品信息")
    @GetMapping("/user/{userId}")
    public Result showInformationByUser(@PathVariable Long userId) {
        List<Information> informationList = informationService.findInformationByUser(userId);
        return Result.wrapSuccessfulResult(informationList);
    }

    @ApiOperation("按类型和名称搜索需求/物品信息")
    @GetMapping("search/{informationType}/{content}")
    public Result searchByTypeAndContent(@PathVariable Integer informationType,
                                         @PathVariable String content) {
        List<Information> informationList = informationService.findInformationByTypeAndContent(informationType, content);
        return Result.wrapSuccessfulResult(informationList);
    }

    @GetMapping("search/{keyword}")
    public Result searchByKeyword(@PathVariable String keyword) {
        List<Information> informationList = informationService.findInformationByKeyword(keyword);
        return Result.wrapSuccessfulResult(informationList);
    }
}
