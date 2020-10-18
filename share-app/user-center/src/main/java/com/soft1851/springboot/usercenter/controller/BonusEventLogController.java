package com.soft1851.springboot.usercenter.controller;

import com.soft1851.springboot.usercenter.domain.entity.BonusEventLog;
import com.soft1851.springboot.usercenter.service.BonusEventLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ke
 * @description TODO
 * @Data 2020/10/15
 */

@Slf4j
@RestController
@RequestMapping(value = "/log")
@Api(tags = "日志接口",value = "提供日志相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusEventLogController {

    private final BonusEventLogService bonusEventLogService;

    @GetMapping
    @ApiOperation(value = "根据用户id查询日志",notes = "根据用户id查询日志")
    public List<BonusEventLog> queryLog(@RequestParam Integer userId){
        return this.bonusEventLogService.queryLog(userId);
    }
}
