package com.igeek.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String PATTERN_DATE_YYYYMD = "yyyy-M-d";
    public static final String PATTERN_DATE_YYYYM = "yyyy-M";
    public static final String PATTERN_DATE_YYYY = "yyyy";
    public static final String DATE_PATTERN = "yyyy年MM月";

    public static Date tryParseDate(String time) {
        try {
            return new SimpleDateFormat(PATTERN_DATE_YYYYMD).parse(time);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat(PATTERN_DATE_YYYYM).parse(time);
            } catch (Exception ex) {
                try {
                    return new SimpleDateFormat(DATE_PATTERN).parse(time);
                } catch (Exception exx) {
                    try {
                        return new SimpleDateFormat(PATTERN_DATE_YYYY).parse(time);
                    } catch (Exception exxx) {
                        e.printStackTrace();
                        ex.printStackTrace();
                        exx.printStackTrace();
                        return new Date();
                    }
                }
            }
        }
    }
}
