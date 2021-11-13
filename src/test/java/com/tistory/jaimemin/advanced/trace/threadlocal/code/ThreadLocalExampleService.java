package com.tistory.jaimemin.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalExampleService {

    private ThreadLocal<Integer> numberStorage = new ThreadLocal<>();

    public Integer storeNumber(Integer number) {
        log.info("저장할 번호: {}, 기존에 저장된 번호: {}", number, numberStorage.get());
        numberStorage.set(number);
        sleep(1000); // 1초 대기
        log.info("저장된 번호 조회: {}", numberStorage.get());

        return numberStorage.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
