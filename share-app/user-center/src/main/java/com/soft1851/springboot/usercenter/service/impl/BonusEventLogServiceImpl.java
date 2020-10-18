package com.soft1851.springboot.usercenter.service.impl;

import com.soft1851.springboot.usercenter.domain.entity.BonusEventLog;
import com.soft1851.springboot.usercenter.mapper.BonusEventLogMapper;
import com.soft1851.springboot.usercenter.service.BonusEventLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ke
 * @description TODO
 * @Data 2020/10/15
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusEventLogServiceImpl implements BonusEventLogService {


    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public List<BonusEventLog> queryLog(Integer userId) {
        Condition condition = new Condition(BonusEventLog.class);
        condition.orderBy("createTime").desc();
        condition.createCriteria().andEqualTo("userId",userId);
        return this.bonusEventLogMapper.selectByExample(condition);
    }
}
