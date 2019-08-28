package com.jay.book.admin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    public static Logger logger = LoggerFactory.getLogger(LogUtil.class.getName());

    public static void debug(String mesage) {
        logger.debug(mesage);
    }

    public static void debug(String mesage, Throwable e) {
        logger.debug(mesage, e);
    }

    public static void debug(String tag, String mesage) {
        logger.debug(tag, mesage);
    }

    public static void debug(String tag, String mesage, Throwable e) {
        logger.debug(tag, mesage, e);
    }

    public static void error(String mesage) {
        logger.error(mesage);
    }

    public static void error(String mesage, Throwable e) {
        logger.error(mesage, e);
    }

    public static void error(String tag, String mesage) {
        logger.error(tag, mesage);
    }

    public static void error(String tag, String mesage, Throwable e) {
        logger.error(tag, mesage, e);
    }
}
