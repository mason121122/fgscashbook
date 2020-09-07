package com.fgs.fgscashbook.utils;

/**
 * @author wangfeng
 * @NAME: UserVo
 * @DATE: 2020/9/7
 **/
public class WdRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 7897423872713679608L;
    private int errorCode;
    private String desc;

    public WdRuntimeException(int errorCode) {
        this.errorCode = errorCode;
    }

    public WdRuntimeException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public WdRuntimeException(int errorCode, String message, String desc) {
        super(message);
        this.errorCode = errorCode;
        this.desc = desc;
    }

    public WdRuntimeException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public WdRuntimeException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
