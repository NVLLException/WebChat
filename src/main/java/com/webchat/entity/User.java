package com.webchat.entity;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String loginName;
    private String nickName;
    private String password;
    private Date createTime;
    private Date lastModifyTime;

    private String headImg;
}
