
package com.example.wis2.trace.logtrace;

import com.example.wis2.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace threadLocalLogTrace = new ThreadLocalLogTrace();
    @Test
    @DisplayName("sync 할 필요가 없이 trace id 를 공유한다")
    void test(){
        TraceStatus traceStatus = threadLocalLogTrace.begin("hello1");
        TraceStatus traceStatus2 = threadLocalLogTrace.begin("hello2");

        threadLocalLogTrace.end(traceStatus2);
        threadLocalLogTrace.end(traceStatus);
    }
    @Test
    @DisplayName("sync 할 필요가 없이 trace id 를 공유한다 w Exception")
    void test1(){
        TraceStatus traceStatus = threadLocalLogTrace.begin("hello1");
        TraceStatus traceStatus2 = threadLocalLogTrace.begin("hello2");

        threadLocalLogTrace.exception(traceStatus2, new IllegalStateException());
        threadLocalLogTrace.exception(traceStatus, new IllegalStateException());
    }
}