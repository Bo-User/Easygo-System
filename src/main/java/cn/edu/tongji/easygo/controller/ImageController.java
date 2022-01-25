package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Image;
import cn.edu.tongji.easygo.service.ImageService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin
@Api(value = "图片", tags = "图片", description = "图片")
public class ImageController {
    @Autowired
    ImageService imageService;

    @ApiOperation("为某information或者comment（type分别为0、1）添加图片")
    @PostMapping("")
    public Result addImage(@RequestBody Image image) {
        if (image.getImageType() != 0 && image.getImageType() != 1)
            return Result.wrapErrorResult("添加失败");
        try {
            boolean flag = imageService.addImage(image.getImageId(), image.getImageUrl(), image.getImageType());
            if (flag)
                return Result.wrapSuccessfulResult("添加成功");
            else
                return Result.wrapErrorResult("已经添加过");
        } catch (Exception e) {
            return Result.wrapErrorResult("添加失败");
        }
    }

    @ApiOperation("查询某information或者comment（type分别为0、1）的图片列表")
    @GetMapping("images/{type}/{id}")
    public Result showImages(@PathVariable Integer type,
                             @PathVariable Long id) {
        List<String> images = imageService.showImages(id, type);
        return Result.wrapSuccessfulResult(images);
    }

    @ApiOperation("删除某information或者comment（type分别为0、1）的图片")
    @DeleteMapping("images/{type}/{id}")
    public Result deleteImages(@PathVariable Integer type,
                               @PathVariable Long id) {
        boolean flag = imageService.deleteImages(id, type);
        if (flag)
            return Result.wrapSuccessfulResult("删除成功");
        else
            return Result.wrapErrorResult("删除失败");
    }
}
