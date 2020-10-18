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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    private Boolean succ;
    private String code;
    private String msg;
    private Object data;
    private Long ts;
}
