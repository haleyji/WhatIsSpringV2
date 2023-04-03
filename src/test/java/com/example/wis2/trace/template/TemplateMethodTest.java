package com.example.wis2.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void test(){
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("====Start Business Logic 1 Start");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time ={}",resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("====Start Business Logic 2 Start");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time ={}",resultTime);

    }
}
