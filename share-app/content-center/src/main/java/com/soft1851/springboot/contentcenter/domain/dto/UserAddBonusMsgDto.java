package com.soft1851.springboot.contentcenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke
 * @description TODO
 * @Data 2020/10/8
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAddBonusMsgDto {
    /**
     * 为谁加积分
     */
    private Integer userId;
    /**
     * 加多少积分
     */
    private Integer bonus;

    /**
     * 描述
     */
    private String description;

    /**
     * 事件
     */
    private String event;
}
