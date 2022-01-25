package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Advertisement;
import cn.edu.tongji.easygo.service.AdvertisementService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/advertisement")
@RestController
@CrossOrigin
@Api(value="广告",tags = "广告",description = "广告")
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;

    @ApiOperation("添加广告")
    @PostMapping("")
    public Result addAdvertisement(@RequestBody Advertisement advertisement){
        advertisementService.addAdvertisement(advertisement);
        return Result.wrapSuccessfulResult("添加成功");
    }

    @ApiOperation("删除某广告")
    @DeleteMapping("{advertisementId}")
    public Result deleteAdvertisement(@PathVariable Long advertisementId){
        advertisementService.deleteAdvertisement(advertisementId);
        return Result.wrapSuccessfulResult("删除成功");
    }

    @ApiOperation("分页查询所有广告信息")
    @GetMapping()
    public Result showAllAdvertisements(@RequestParam("page") Integer pageNum,
                                                        @RequestParam("size") Integer sizeNum){
        try{
            List<Advertisement> advertisements = advertisementService.showAllAdvertisement(pageNum, sizeNum);
            return Result.wrapSuccessfulResult(advertisements);
        }
        catch(Exception e)
        {
            return Result.wrapErrorResult("查询失败");
        }
    }

    @ApiOperation("查询某广告信息")
    @GetMapping("{advertisementId}")
    public Result showAdvertisement(@PathVariable("advertisementId") Long advertisementId){
        Advertisement advertisement = advertisementService.showConcreteAdvertisement(advertisementId);
        return Result.wrapSuccessfulResult(advertisement);
    }

    @ApiOperation("修改某广告信息")
    @PutMapping("{advertisementId}")
    public Result updateAdvertisement(@PathVariable("advertisementId") Long advertisementId,@RequestBody Advertisement advertisement){
        try {
            advertisementService.updateAdvertisement(advertisementId,advertisement);
            return Result.wrapSuccessfulResult("修改成功");
        } catch (Exception e) {
            return Result.wrapErrorResult("修改失败");
        }
    }

    @ApiOperation("查询展示到首页的（state为1）的广告信息")
    @GetMapping("front")
    public Result frontAdvertisements(){
        List<Advertisement> advertisements = advertisementService.showFrontAdvertisement();
        return Result.wrapSuccessfulResult(advertisements);
    }

}
