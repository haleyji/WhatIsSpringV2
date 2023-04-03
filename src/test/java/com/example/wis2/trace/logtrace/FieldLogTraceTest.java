package com.example.wis2.trace.logtrace;

import com.example.wis2.trace.TraceId;
import com.example.wis2.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FieldLogTraceTest {

    FieldLogTrace fieldLogTrace = new FieldLogTrace();
    @Test
    @DisplayName("sync 할 필요가 없이 trace id 를 공유한다")
    void test(){
        TraceStatus traceStatus = fieldLogTrace.begin("hello1");
        TraceStatus traceStatus2 = fieldLogTrace.begin("hello2");

        fieldLogTrace.end(traceStatus2);
        fieldLogTrace.end(traceStatus);
    }
    @Test
    @DisplayName("sync 할 필요가 없이 trace id 를 공유한다 w Exception")
    void test1(){
        TraceStatus traceStatus = fieldLogTrace.begin("hello1");
        TraceStatus traceStatus2 = fieldLogTrace.begin("hello2");

        fieldLogTrace.exception(traceStatus2, new IllegalStateException());
        fieldLogTrace.exception(traceStatus, new IllegalStateException());
    }
}