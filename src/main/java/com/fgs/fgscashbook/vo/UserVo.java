package com.fgs.fgscashbook.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wangfeng
 * @NAME: UserVo
 * @DATE: 2020/9/6
 **/
@Data
public class UserVo {
    @ApiModelProperty(value = "id")
    @NotNull(message = "NOT_NULL")
    private Integer id;

    @ApiModelProperty(value = "账户名")
    @NotNull(message = "NOT_NULL")
    private String user;

    @ApiModelProperty(value = "昵称")
    @NotNull(message = "NOT_NULL")
    private String nickname;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "NOT_NULL")
    private String password;

    @ApiModelProperty(value = "头像")
    private String photo;

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "NOT_NULL")
    private Integer roleId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "账户状态（0：启用 1：注销  2 :其他）")
    private Integer type;

    private Data creationTime;
    private String creationBy;
    private Data updateTime;
    private String updateBy;

}
