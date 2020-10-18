package com.soft1851.springboot.contentcenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ke
 * @description TODO
 * @Data 2020/10/15
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BonusEventLogDto {
    private Integer id;


    private Integer userId;

    private Integer value;

    private String event;

    private Date createTime;

    private String description;
}
