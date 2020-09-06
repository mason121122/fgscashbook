package com.fgs.fgscashbook.support;

import java.io.Serializable;

/**
 * @author wangfeng
 * @NAME: ReturnResult
 * @DATE: 2020/9/6
 **/
public class ReturnResult<T> implements Serializable {

    private static final long serialVersionUID = -8379100651362895882L;

//    @ApiModelProperty(value = "返回状态")
    private int status;

//    @ApiModelProperty(value = "返回消息")
    private String message;

//    @ApiModelProperty(value = "返回数据")
    private T data;

    public ReturnResult() {
    }

    public ReturnResult(int status) {
        this(status, null);
    }

    public ReturnResult(int status, String message) {
        this(status, message, null);
    }

    public ReturnResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
