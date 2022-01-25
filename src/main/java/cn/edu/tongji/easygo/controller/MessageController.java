package cn.edu.tongji.easygo.controller;

import cn.edu.tongji.easygo.model.Message;
import cn.edu.tongji.easygo.service.MessageService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("api/v1/message")
@RestController
@CrossOrigin
@Api(value="消息",tags = "消息",description = "消息")
public class MessageController {
    @Resource
    MessageService messageService;

    @ApiOperation("发送消息")
    @PostMapping("")
    public Result sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
        return Result.wrapSuccessfulResult("发送消息成功");
    }

    @ApiOperation("删除消息")
    @DeleteMapping("{messageId}")
    public Result deleteMessage(@PathVariable("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
        return Result.wrapSuccessfulResult("删除消息成功");
    }

    @ApiOperation("查询某用户的消息")
    @GetMapping("/user/{userId}")
    public Result showMessageByUser(@PathVariable("userId") Long userId) {
        return Result.wrapSuccessfulResult(messageService.showAllMessageByUser(userId));
    }

    @ApiOperation("查看某消息")
    @GetMapping("{messageId}")
    public Result showConcreteMessage(@PathVariable("messageId") Long messageId) {
        return Result.wrapSuccessfulResult(messageService.showAllMessageByUser(messageId));
    }

    @ApiOperation("修改某消息")
    @PutMapping("{messageId}")
    public Result readMessage(@PathVariable("messageId") Long messageId) {
        messageService.readMessage(messageId);
        return Result.wrapSuccessfulResult("消息已读成功");
    }
}