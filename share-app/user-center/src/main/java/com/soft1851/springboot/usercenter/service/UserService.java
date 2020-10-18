package com.soft1851.springboot.usercenter.service;


import com.soft1851.springboot.usercenter.domain.dto.LoginDto;
import com.soft1851.springboot.usercenter.domain.dto.UserAddBonusMsgDto;
import com.soft1851.springboot.usercenter.domain.entity.BonusEventLog;
import com.soft1851.springboot.usercenter.domain.entity.User;

import java.util.List;


/**
 * @author ke
 * @description TODO
 * @Data 2020/9/29
 */
public interface UserService {


    /**
      * 根据id获得用户详情
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据id给用户加积分
     * @param userAddBonusMsgDto
     * @return
     */
    void addBonusById(UserAddBonusMsgDto userAddBonusMsgDto);

    /**
     * 登录
     * @param loginDto
     * @return
     */
    User login(LoginDto loginDto);






}
