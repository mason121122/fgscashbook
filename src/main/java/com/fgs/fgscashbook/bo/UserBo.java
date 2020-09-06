package com.fgs.fgscashbook.bo;

import lombok.Data;

/**
 * @author wangfeng
 * @NAME: UserBo
 * @DATE: 2020/9/6
 **/
@Data
public class UserBo {
    private Integer id;
    private String user;
    private String nickname;
    private String password;
    private String photo;
    private Integer roleId;
    private String remark;
    private Integer type;
    private Data creationTime;
    private String creationBy;
    private Data updateTime;
    private String updateBy;
}
