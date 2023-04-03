package com.example.wis2;

import com.example.wis2.trace.logtrace.FieldLogTrace;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

@Configuration
public class LogTraceConfig {

    @Bean(name = "fieldLogTrace")
    public LogTrace logTrace1(){
        return new FieldLogTrace();
    }
    @Bean(name = "threadLocalLogTrace")
    public LogTrace logTrace2(){
        return new ThreadLocalLogTrace();
    }
}
