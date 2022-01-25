package cn.edu.tongji.easygo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.easygo.dto.UserLoginDTO;
import cn.edu.tongji.easygo.dto.UserRegisterDTO;
import cn.edu.tongji.easygo.model.User;
import cn.edu.tongji.easygo.service.UserService;
import cn.edu.tongji.easygo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
@Api(value = "用户", tags = "用户", description = "用户")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("登录")
    @GetMapping("login")
    public Result login(@RequestParam("userId") Long userId, @RequestParam("userPassword") String password) {
        UserLoginDTO info = new UserLoginDTO();
        User loginUser = userService.login(userId, password);
        if (loginUser != null) {
            StpUtil.login(userId);
            info.setUserId(loginUser.getUserId());
            info.setUserName(loginUser.getUserName());
            info.setUserAvatar(loginUser.getUserAvatar());
            info.setUserRole(loginUser.getUserRole());
            info.setResult("登录成功");
            info.setToken(StpUtil.getTokenValue());
            return Result.wrapSuccessfulResult(info);
        } else {
            return Result.wrapErrorResult("登录失败");
        }
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public Result register(@RequestBody UserRegisterDTO registerInfo) {
        if (userService.register(registerInfo) != null)
            return Result.wrapSuccessfulResult("注册成功");
        else
            return Result.wrapErrorResult("注册失败");
    }

    @ApiOperation("删除用户")
    @DeleteMapping("{userId}")
    public Result deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return Result.wrapSuccessfulResult("删除成功");
    }

    @ApiOperation("分页查询所有用户信息")
    @GetMapping()
    public Result showAllUsers(@RequestParam("page") Integer page,
                               @RequestParam("size") Integer size) {
        return Result.wrapSuccessfulResult(userService.showAllUser(page, size));
    }

    @ApiOperation("查询某用户信息")
    @GetMapping("{userId}")
    public Result showConcreteUser(@PathVariable("userId") Long userId) {
        return Result.wrapSuccessfulResult(userService.showConcreteUser(userId));
    }

    @ApiOperation("修改某用户信息")
    @PutMapping("{userId}")
    public Result updateUser(@PathVariable("userId") Long userId, @RequestBody User updateUserInfo) {
        try {
            userService.updateUser(userId, updateUserInfo);
            return Result.wrapSuccessfulResult("修改成功");
        } catch (Exception e) {
            return Result.wrapErrorResult("修改失败");
        }
    }
}
