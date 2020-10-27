package com.fgs.fgscashbook.po;

import lombok.Data;

import java.util.Date;

/**
 * @author wangfeng
 * @NAME: UserPo
 * @DATE: 2020/9/6
 **/
@Data
public class UserPo {
    private Integer id;
    private String user;
    private String nickname;
    private String password;
    private String photo;
    private Integer roleId;
    private String remark;
    private Integer type;
    private Date creationTime;
    private String creationBy;
    private Date updateTime;
    private String updateBy;
}
