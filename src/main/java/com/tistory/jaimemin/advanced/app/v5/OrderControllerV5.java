package com.tistory.jaimemin.advanced.app.v5;

import com.tistory.jaimemin.advanced.trace.callback.TraceCallback;
import com.tistory.jaimemin.advanced.trace.callback.TraceTemplate;
import com.tistory.jaimemin.advanced.trace.logtrace.LogTrace;
import com.tistory.jaimemin.advanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;

    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace); // singleton
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new TraceCallback<String>() {

            @Override
            public String call() {
                orderService.orderItem(itemId);

                return "ok";
            }
        });
    }
}
