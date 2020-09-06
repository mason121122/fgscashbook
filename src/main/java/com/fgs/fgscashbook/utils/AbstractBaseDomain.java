package com.fgs.fgscashbook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangfeng
 * @NAME: AbstractBaseDomain
 * @DATE: 2020/9/6
 **/
public abstract class AbstractBaseDomain {
    protected static Logger logger = LoggerFactory.getLogger("COMMON.LOG");

    protected void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    protected void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    protected void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    protected void error(String message, Throwable th) {
        if (logger.isErrorEnabled()) {
            logger.error(message, th);
        }
    }
}
