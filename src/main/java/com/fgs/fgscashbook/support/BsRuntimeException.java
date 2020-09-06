package com.fgs.fgscashbook.support;


import com.fgs.fgscashbook.enums.ResultEnum;

/**
 * @author wangfeng
 * @NAME: BsRuntimeException
 * @DATE: 2020/9/6
 **/
public class BsRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BsRuntimeException(String msg) {
        super(msg);
    }
    public BsRuntimeException(String f, Object... msg) {
        super(String.format(f, msg));
    }
    public BsRuntimeException(ResultEnum error) {
        super(error.getMessage());
    }

    // 用于支持异常迭代
    public BsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
