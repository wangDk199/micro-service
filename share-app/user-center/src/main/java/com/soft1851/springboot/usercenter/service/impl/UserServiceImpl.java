package com.soft1851.springboot.usercenter.service.impl;

import com.soft1851.springboot.usercenter.domain.dto.LoginDto;
import com.soft1851.springboot.usercenter.domain.dto.UserAddBonusMsgDto;
import com.soft1851.springboot.usercenter.domain.entity.BonusEventLog;
import com.soft1851.springboot.usercenter.domain.entity.User;
import com.soft1851.springboot.usercenter.mapper.BonusEventLogMapper;
import com.soft1851.springboot.usercenter.mapper.UserMapper;
import com.soft1851.springboot.usercenter.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author ke
 * @description TODO
 * @Data 2020/9/29
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;
    @Override
    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addBonusById(UserAddBonusMsgDto userAddBonusMsgDto) {
//        User user = userMapper.selectByPrimaryKey(userAddBonusMsgDto.getUserId());
//        user.setBonus(user.getBonus() + userAddBonusMsgDto.getBonus());
//        this.userMapper.updateByPrimaryKeySelective(user);
//
//        //2、写积分日志
//        this.bonusEventLogMapper.insert(BonusEventLog.builder()
//                .userId(user.getId())
//                .value(userAddBonusMsgDto.getBonus())
//                .event("CONTRIBUTE")
//                .createTime(LocalDateTime.now())
//                .description("投稿加积分")
//                .build());
//        return user;
        System.out.println(userAddBonusMsgDto);
        // 1. 为用户加积分
        Integer userId = userAddBonusMsgDto.getUserId();
        Integer bonus = userAddBonusMsgDto.getBonus();
        User user = this.userMapper.selectByPrimaryKey(userId);

        user.setBonus(user.getBonus() + bonus);
        this.userMapper.updateByPrimaryKeySelective(user);

        // 2. 记录日志到bonus_event_log表里面
        this.bonusEventLogMapper.insert(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(bonus)
                        .event(userAddBonusMsgDto.getEvent())
                        .createTime(new Date())
                        .description(userAddBonusMsgDto.getDescription())
                        .build()
        );
        log.info("积分添加完毕...");
    }


    @Override
    public User login(LoginDto loginDto) {
        //先根据wxId查找用户
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wxId",loginDto.getOpenId());
        List<User> users = this.userMapper.selectByExample(example);
        //没找到用户，是新用户，直接注册
        if (users.size() == 0){
            User saveUser = User.builder()
                    .wxId(loginDto.getOpenId())
                    .avatarUrl(loginDto.getAvatarUrl())
                    .wxNickName(loginDto.getWxNickName())
                    .roles("user")
                    .bonus(188)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            this.userMapper.insertSelective(saveUser);
            return saveUser;
        }
        return users.get(0);
    }


}
