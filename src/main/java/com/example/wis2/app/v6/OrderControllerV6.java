package com.example.wis2.app.v6;

import com.example.wis2.trace.callback.TraceCallback;
import com.example.wis2.trace.callback.TraceTemplate;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV6 {

    private final OrderServiceV6 orderService;
    private final TraceTemplate traceTemplate;

    public OrderControllerV6(OrderServiceV6 orderService,  LogTrace threadLocalLogTrace) {
        this.orderService = orderService;
        this.traceTemplate = new TraceTemplate(threadLocalLogTrace);
    }

    @GetMapping("/v6/request")
    public String request(String itemId) {
        return traceTemplate.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
