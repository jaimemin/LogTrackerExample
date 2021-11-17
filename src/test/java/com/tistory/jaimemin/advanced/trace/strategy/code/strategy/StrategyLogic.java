package com.tistory.jaimemin.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic implements Strategy {

    @Override
    public void call() {
        log.info("비즈니스 로직 실행");
    }
}
