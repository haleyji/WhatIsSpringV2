package com.example.wis2.app.v5;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final LogTrace threadLocalLogTrace;
    @GetMapping("/v5/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<String>(threadLocalLogTrace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()");
    }
}
