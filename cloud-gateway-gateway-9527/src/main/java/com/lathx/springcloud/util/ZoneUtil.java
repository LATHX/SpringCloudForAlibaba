package com.lathx.springcloud.util;

import java.time.ZonedDateTime;

public class ZoneUtil {
    // 获得当前默认时区
    public static String defaultZone(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        return zonedDateTime.toString();
    }
}
