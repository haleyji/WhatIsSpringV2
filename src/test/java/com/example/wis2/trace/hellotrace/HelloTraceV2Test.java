package com.example.wis2.trace.hellotrace;

import com.example.wis2.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTraceV2Test {

    @Autowired HelloTraceV2 helloTraceV2;
    @Test
    @DisplayName("Trace Has 2 level depth")
    void test() {
        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
        TraceStatus status3 = helloTraceV2.beginSync(status2.getTraceId(), "hello3");
        helloTraceV2.end(status3);
        helloTraceV2.end(status2);
        helloTraceV2.end(status1);
    }

    @Test
    @DisplayName("Trace Has 2 level depth with Exception")
    void test1() {
        TraceStatus status1 = helloTraceV2.begin("hello");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
        helloTraceV2.exception(status2, new IllegalStateException());
        helloTraceV2.exception(status1, new IllegalStateException());
    }
}