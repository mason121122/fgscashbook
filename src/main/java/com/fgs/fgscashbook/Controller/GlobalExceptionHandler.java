package com.fgs.fgscashbook.Controller;

import com.fgs.fgscashbook.enums.ResultEnum;
import com.fgs.fgscashbook.support.BsRuntimeException;
import com.fgs.fgscashbook.support.ReturnResult;
import com.fgs.fgscashbook.utils.WdRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author wangfeng
 * @NAME: GlobalExceptionHandler
 * @DATE: 2020/9/7
 **/
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger("WEB.LOG");

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnResult<Object> defaultErrorHandler(final HttpServletRequest req, HttpServletResponse resp, final Exception e) throws Exception {
        /*  使用response返回    */
        resp.setStatus(HttpStatus.OK.value()); //设置状态码
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        resp.setCharacterEncoding("UTF-8"); //避免乱码
        resp.setHeader("Cache-Control", "no-cache, must-revalidate");

        ResultEnum resultEnu;
        String cause = null;
        int _errCode;
        String _errMsg;
        if (e instanceof NoHandlerFoundException) {
            NoHandlerFoundException ne = (NoHandlerFoundException) e;
            cause = ne.getMessage();

            writeErrorLog("Path Not Found!", ne);
            resultEnu = ResultEnum.PATH_NOT_FOUND;

            _errCode = resultEnu.getCode();
            _errMsg = resultEnu.getDesc();
        } else if (e instanceof MethodArgumentNotValidException || e instanceof BindException) {
            cause = e.getMessage();
            List<FieldError> feList;
            if (e instanceof MethodArgumentNotValidException) {
                feList = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
            } else {
                feList = ((BindException) e).getBindingResult().getFieldErrors();
            }
            FieldError fieldError = null;
            if (!CollectionUtils.isEmpty(feList)) {
                for (FieldError _fe : feList) {
                    if (_fe != null) {
                        fieldError = _fe;
                        break;
                    }
                }
            }
            if (fieldError != null) {
                String tmpMsgCode = fieldError.getDefaultMessage();
                try {
                    resultEnu = ResultEnum.getByMsg(tmpMsgCode);
                    _errMsg = resultEnu.getDesc();
                } catch (Exception e1) {
                    resultEnu = ResultEnum.SYS_ERROR;
                    _errMsg = tmpMsgCode;
                }
                _errCode = resultEnu.getCode();
            } else {
                resultEnu = ResultEnum.SYS_ERROR;
                _errCode = resultEnu.getCode();
                _errMsg = resultEnu.getDesc();
            }
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) e;
            cause = exs.getMessage();
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();

            ConstraintViolation<?> item = null;
            if (violations != null && !violations.isEmpty()) { //取一个错误
                for (ConstraintViolation<?> _item : violations) {
                    if (_item != null) {
                        item = _item;
                        break;
                    }
                }
            }
            if (item != null) {
                String tmpMsgCode = item.getMessage();
                try {
                    resultEnu = ResultEnum.getByMsg(tmpMsgCode);
                    _errMsg = resultEnu.getDesc();
                } catch (Exception e1) {
                    resultEnu = ResultEnum.SYS_ERROR;
                    _errMsg = tmpMsgCode;
                }
                _errCode = resultEnu.getCode();
            } else {
                resultEnu = ResultEnum.SYS_ERROR;
                _errCode = resultEnu.getCode();
                _errMsg = resultEnu.getDesc();
            }
        } else if (e instanceof WdRuntimeException) {
            WdRuntimeException exception = (WdRuntimeException) e;
            cause = exception.getMessage();

            resultEnu = ResultEnum.getByMsg(exception.getMessage());

            _errCode = resultEnu.getCode();
            _errMsg = resultEnu.getDesc();
        } else if (e instanceof BsRuntimeException) {
            BsRuntimeException exception = (BsRuntimeException) e;
            resultEnu = ResultEnum.getByMsg(exception.getMessage());
            _errCode = resultEnu.getCode();
            if (resultEnu.getCode() == ResultEnum.UNKNOWN.getCode()) {
                _errMsg = exception.getMessage();
            } else {
                _errMsg = resultEnu.getDesc();
            }
        } else {
            logger.error("ExceptionHandler sys exception", e);
            resultEnu = ResultEnum.SYS_ERROR;
            cause = e.getMessage();

            _errCode = resultEnu.getCode();
            _errMsg = resultEnu.getDesc() + cause;
        }
        return new ReturnResult<>(_errCode, _errMsg, null);
    }

    @ExceptionHandler(MultipartException.class)
    public ReturnResult handleMultipartException(MultipartException e) {
        logger.info("【文件上传发生异常，异常原因={}.】", e.getMessage());
        return new ReturnResult<>(10000, "文件大小超过最大限制200KB");
    }

    @ExceptionHandler(NumberFormatException.class)
    public ReturnResult handleNumberFormatException(NumberFormatException e) {
        logger.info("【数字格式化发生异常，异常原因={}.】", e.getMessage());
        return new ReturnResult<>(10001, e.getMessage().replace("For input string:", "不是正确的数字:").replace("\"", ""));
    }

    public void writeErrorLog(final String message, final Throwable t) {
        if (logger.isErrorEnabled()) {
            logger.error(message, t);
        }
    }

    public void writeErrorLog(final String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }
}
