package com.researchpanelasia;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 问候语生成类，根据当前时间返回不同问候语
 */
public class MyGreeter {

    private static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("HH");

    /**
     * 根据当前时间返回对应问候语
     * @return 问候语字符串
     */
    public String greeting() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        if (hour >= 6 && hour < 12) {
            return "Good morning";
        } else if (hour >= 12 && hour < 18) {
            return "Good afternoon";
        } else {
            return "Good evening";
        }
    }
}
