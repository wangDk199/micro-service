package com.soft1851.springboot.usercenter.controller;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.soft1851.springboot.usercenter.domain.dto.*;
import com.soft1851.springboot.usercenter.domain.entity.BonusEventLog;
import com.soft1851.springboot.usercenter.domain.entity.User;
import com.soft1851.springboot.usercenter.service.UserService;
import com.soft1851.springboot.usercenter.util.JwtOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ke
 * @description TODO
 * @Data 2020/9/29
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户接口",value = "提供用户相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;
    private final JwtOperator jwtOperator;


    @GetMapping
    @ApiOperation(value = "根据用户id查询用户",notes = "根据用户id查询用户")
    public User findUserById(@RequestParam Integer id){
        log.info("我被调用了....");
        return userService.findById(id);
    }

    @PostMapping(value = "/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/q")
    public User query(User user){
        return user;
    }

    @PostMapping("/addBonus")
    @ApiOperation(value = "根据用户id加积分",notes = "根据用户id加积分")
    public User addBonusById(@RequestBody  UserAddBonusMsgDto userAddBonusMsgDto){
        Integer userId = userAddBonusMsgDto.getUserId();
        userService.addBonusById(
                UserAddBonusMsgDto.builder()
                        .userId(userId)
                        .bonus(userAddBonusMsgDto.getBonus())
                        .description(userAddBonusMsgDto.getDescription())
                        .event(userAddBonusMsgDto.getEvent())
                        .build()
        );
        return this.userService.findById(userId);
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录",notes = "登录")
    public LoginRespDto getUser(@RequestBody LoginDto loginDto){
        User user = this.userService.login(loginDto);
        //颁发token
        Map<String,Object> userInfo = new HashMap<>(3);
        userInfo.put("id",user.getId());
        userInfo.put("wxNickName",user.getWxNickName());
        userInfo.put("role",user.getRoles());
        String token = jwtOperator.generateToken(userInfo);

        log.info(
                "{}登录成功，生成的token = {},有效期到:{}",
                user.getWxNickName(),
                token,
                jwtOperator.getExpirationTime()
        );
        return LoginRespDto.builder()
                .user(UserRespDto.builder()
                .id(user.getId())
                .avatarUrl(user.getAvatarUrl())
                .wxNickName(user.getWxNickName())
                .bonus(user.getBonus())
                .build())
                .token(JwtTokenRespDto
                .builder()
                .token(token)
                .expirationTime(jwtOperator.getExpirationTime().getTime())
                .build())
                .build();
    }


}