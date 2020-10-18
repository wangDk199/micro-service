package com.soft1851.springboot.contentcenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke
 * @description TODO
 * @Data 2020/10/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeDto {
    private Integer userId;
    private Integer shareId;
}
