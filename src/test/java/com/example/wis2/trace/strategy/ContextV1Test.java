package com.example.wis2.trace.strategy;

import com.example.wis2.trace.strategy.code.strategy.ContextV1;
import com.example.wis2.trace.strategy.code.strategy.Strategy;
import com.example.wis2.trace.strategy.code.strategy.StrategyLogic1;
import com.example.wis2.trace.strategy.code.strategy.StrategyLogic2;
import com.example.wis2.trace.template.code.AbstractTemplate;
import com.example.wis2.trace.template.code.SubClassLogic1;
import com.example.wis2.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import javax.naming.Context;
import java.net.ContentHandler;

@Slf4j
public class ContextV1Test {

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

    @Test
    void test3(){
        Strategy strategy = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();

        Strategy strategy1 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategy1);
        contextV2.execute();
    }

    @Test
    void test4(){
        Strategy strategy = new Strategy() {
            @Override
            public void call() {
                log.info("business logic 1 start...");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();

        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("business logic 2 start...");
            }
        };
        ContextV1 contextV11 = new ContextV1(strategy1);
        contextV11.execute();

    }

    @Test
    void test5(){
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("business logic 1");
            }
        });
        context1.execute();

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("business logic 2");
            }
        });
        context2.execute();

    }
    @Test
    void test6(){
        //람다로 쓰려면, interface 에 method 하 나 만 있어야 한다!
        ContextV1 context1 = new ContextV1(() -> log.info("business logic 1 starts..."));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("business logic 2 starts..."));
        context2.execute();
    }
}
