package com.tistory.jaimemin.advanced.trace.template;

import com.tistory.jaimemin.advanced.trace.template.code.AbstractTemplate;
import com.tistory.jaimemin.advanced.trace.template.code.SubClassLogic;
import com.tistory.jaimemin.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic();
        logic2();
    }

    private void logic() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직 실행");
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 템플릿 메서드 패턴 적용
     *
     * 코드 중복 제외
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate template = new SubClassLogic();
        template.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    /**
     * 템플릿 메서드 패턴 적용
     *
     * 익명 내부 클래스
     */
    @Test
    void templateMethodV2() {
        AbstractTemplate template = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("비즈니스 로직 실행");
            }
        };
        log.info("클래스 이름={}", template.getClass());
        template.execute();

        AbstractTemplate template2 = new AbstractTemplate() {

            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        template2.execute();
        log.info("클래스 이름2={}", template.getClass());
    }
}
