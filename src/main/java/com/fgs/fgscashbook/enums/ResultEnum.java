package com.fgs.fgscashbook.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author wangfeng
 * @NAME: UserVo
 * @DATE: 2020/9/6
 **/
public enum ResultEnum {

    SUCCESS(200, "SUCCESS", "成功"),
    PATH_NOT_FOUND(404, "PATH_NOT_FOUND", "请求地址不存在"),

    /**
     * 参数错误
     */
    COUPON_TYPE_NULL_ERROR(1000, "COUPON_TYPE_NULL_ERROR", "类型不能为空"),
    COUPON_TYPE_SELECT_ERROR(1001, "COUPON_TYPE_SELECT_ERROR", "类型选择错误"),
    PAGE_NULL_SELECT_ERROR(1002, "PAGE_NULL_SELECT_ERROR", "页码不能为空"),
    PAGE_MIN_SELECT_ERROR(1003, "PAGE_MIN_SELECT_ERROR", "页码不能小于1"),
    PAGE_SIZE_NULL_SELECT_ERROR(1004, "PAGE_SIZE_NULL_SELECT_ERROR", "每页显示条数不能为空"),
    PAGE_SIZE_MAX_SELECT_ERROR(1005, "PAGE_SIZE_MAX_SELECT_ERROR", "每页显示条数不能大于100"),
    COUPON_PIC_NULL_ERROR(1006, "COUPON_PIC_NULL_ERROR", "图标不能为空"),
    COUPON_DESCRIPTION_NULL_ERROR(1007, "COUPON_DESCRIPTION_NULL_ERROR", "介绍不能为空"),
    COUPON_TITLE_NULL_ERROR(1008, "COUPON_TITLE_NULL_ERROR", "标题不能为空"),
    NOT_NULL(1009,"NOT_NULL","参数不能为空"),


    /**
     * 业务错误
     */
    SYS_ERROR(5000, "SYS_ERROR", "[系统异常]"),
    NOT_FOUND(5001, "NOT_FOUND", "数据未找到"),
    ADD_FAIL(5002, "ADD_FAIL", "数据添加失败"),

    /**
     * 系统错误99xx
     */
    DB_ERROR(9998, "DB_ERROR", "数据库异常"),
    FAILURE(9999, "FAILURE", "业务失败"),
    UNKNOWN(-1, "UNKNOWN", "未定义错误");

    private final int code;
    private final String message;
    private String desc;

    ResultEnum(int code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }

    public static ResultEnum valueOf(int code) {
        ResultEnum[] enums = values();
        if (enums == null || enums.length == 0) {
            return UNKNOWN;
        }
        for (ResultEnum _enu : enums) {
            if (code == _enu.getCode()) {
                return _enu;
            }
        }
        return UNKNOWN;
    }

    public static ResultEnum getByMsg(String message) {
        ResultEnum[] enums = values();
        if (enums == null || enums.length == 0) {
            return UNKNOWN;
        }
        for (ResultEnum _enu : enums) {
            if (message.equals(_enu.getMessage())) {
                return _enu;
            }
        }
        return UNKNOWN;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        try {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("code", code)
                    .append("message", message)
                    .append("desc", desc)
                    .toString();
        } catch (Exception e) {
            // NOTICE: 这样做的目的是避免由于toString()的异常导致系统异常终止
            // 大部分情况下，toString()用在日志输出等调试场景
            return super.toString();
        }
    }
}
