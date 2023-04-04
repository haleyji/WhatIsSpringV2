package com.example.wis2.trace.template;

import com.example.wis2.trace.template.code.AbstractTemplate;
import com.example.wis2.trace.template.code.SubClassLogic1;
import com.example.wis2.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void test() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("====Start Business Logic 1 Start");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time ={}", resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("====Start Business Logic 2 Start");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time ={}", resultTime);

    }

    /**
     * 템플릿 메서드 패턴 적용
     **/
    @Test
    void test1() {
        AbstractTemplate abstractTemplate = new SubClassLogic1();
        abstractTemplate.execute();

        AbstractTemplate abstractTemplate2 = new SubClassLogic2();
        abstractTemplate2.execute();
    }

    @Test
    void test2() {
        AbstractTemplate abstractTemplate = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("business logic start...1");
            }
        };
        log.info("class name is={}", abstractTemplate.getClass().getName());
        abstractTemplate.execute();

        AbstractTemplate abstractTemplate1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("business logic start...2");
            }
        };
        abstractTemplate1.execute();
        log.info("class name is={}", abstractTemplate1.getClass().getName());
    }
}
