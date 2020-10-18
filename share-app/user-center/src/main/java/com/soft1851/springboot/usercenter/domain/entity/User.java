package com.soft1851.springboot.usercenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ke
 * @description TODO
 * @Data 2020/9/29
 */

@Table(name = "user")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "wx_id")
    private String wxId;

    @Column(name = "wx_nickname")
    private String wxNickName;

    @Column(name = "roles")
    private String roles;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "bonus")
    private Integer bonus;
}
