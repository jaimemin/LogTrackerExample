package com.tistory.jaimemin.advanced.trace.threadlocal;

import com.tistory.jaimemin.advanced.trace.threadlocal.code.ExampleService;
import com.tistory.jaimemin.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExampleServiceTest {

    private ExampleService exampleService = new ExampleService();

    @Test
    void field() {
        log.info("main start");

        Runnable storeOne = () -> {
            exampleService.storeNumber(1);
        };
        Runnable storeTwo = () -> {
            exampleService.storeNumber(2);
        };

        Thread threadA = new Thread(storeOne);
        threadA.setName("thread-1");
        Thread threadB = new Thread(storeTwo);
        threadB.setName("thread-2");

        threadA.start();
        sleep(100); // 동시성 문제 발생
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료 대기

        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
