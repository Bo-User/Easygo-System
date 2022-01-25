package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.service.OssService;

import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/oss")
@CrossOrigin
@Api(value="对象存储OSS",tags = "对象存储OSS",description = "对象存储OSS")
public class OssController {
    @Autowired
    OssService ossService;

    @ApiOperation("上传图片")
    @PostMapping
    public Result uploadPic(MultipartFile file)
    {
        String url = ossService.uploadFilePic(file);
        return Result.wrapSuccessfulResult(url);
    }
}
