package com.example.wis2.trace.strategy;

import com.example.wis2.trace.strategy.code.strategy.ContextV2;
import com.example.wis2.trace.strategy.code.strategy.Strategy;
import com.example.wis2.trace.strategy.code.strategy.StrategyLogic1;
import com.example.wis2.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    void test(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());

    }


    //전략 패턴 익명 내부 클래스
    @Test
    void test2(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy(){
            @Override
            public void call() {
                log.info("business logic 1 starts...");
            }
        });
        contextV2.execute(() -> {
            log.info("business logic 2 starts...");
        });

    }
}
