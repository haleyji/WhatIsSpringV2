package com.example.wis2.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic2 implements Strategy {
    @Override
    public void call() {
        log.info("logic 2 starts..");
    }
}
