package com.researchpanelasia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * MyGreeter类的单元测试
 */
public class MyGreeterTest {

    private MyGreeter myGreeter;

    @BeforeEach
    void setUp() {
        myGreeter = new MyGreeter();
    }

    @Test
    void testGreetingMorning() {
        // 模拟早上8点
        LocalTime mockTime = LocalTime.of(8, 0);
        ZonedDateTime mockZonedTime = ZonedDateTime.of(LocalDateTime.from(mockTime), ZoneId.systemDefault());

        // 使用Mockito模拟LocalTime.now()
        when(LocalTime.now()).thenReturn(mockTime);

        String result = myGreeter.greeting();
        assertEquals("Good morning", result, "早上问候语应返回Good morning");
    }

    @Test
    void testGreetingAfternoon() {
        // 模拟下午2点
        LocalTime mockTime = LocalTime.of(14, 0);
        when(LocalTime.now()).thenReturn(mockTime);

        String result = myGreeter.greeting();
        assertEquals("Good afternoon", result, "下午问候语应返回Good afternoon");
    }

    @Test
    void testGreetingEvening() {
        // 模拟晚上8点
        LocalTime mockTime = LocalTime.of(20, 0);
        when(LocalTime.now()).thenReturn(mockTime);

        String result = myGreeter.greeting();
        assertEquals("Good evening", result, "晚上问候语应返回Good evening");
    }

    @Test
    void testGreetingEarlyMorning() {
        // 模拟凌晨2点
        LocalTime mockTime = LocalTime.of(2, 0);
        when(LocalTime.now()).thenReturn(mockTime);

        String result = myGreeter.greeting();
        assertEquals("Good evening", result, "凌晨问候语应返回Good evening");
    }
}