package com.example.wis2.trace.strategy;

import com.example.wis2.trace.strategy.code.template.Callback;
import com.example.wis2.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    @Test
    void test(){
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(new Callback() {
            @Override
            public void call() {
                log.info("business logic 1 starts..");
            }
        });
        timeLogTemplate.execute(() -> {
            log.info("business logic 2 starts...");
        });
    }


}
