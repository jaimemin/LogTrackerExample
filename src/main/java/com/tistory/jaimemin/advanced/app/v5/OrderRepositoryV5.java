package com.tistory.jaimemin.advanced.app.v5;

import com.tistory.jaimemin.advanced.trace.callback.TraceTemplate;
import com.tistory.jaimemin.advanced.trace.logtrace.LogTrace;
import com.tistory.jaimemin.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute("OrderRepository.save()", () -> {
            if ("ex".equals(itemId)) {
                throw new IllegalStateException("예외 발생");
            }

            sleep(1000);

            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
