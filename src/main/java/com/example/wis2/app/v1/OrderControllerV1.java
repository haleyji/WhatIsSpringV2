package com.example.wis2.app.v1;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 helloTraceV1;
    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV1.begin("OrderController.request()");
            orderService.orderItem(itemId);
            helloTraceV1.end(traceStatus);
            return "ok";
        } catch (Exception e) {
            helloTraceV1.exception(traceStatus, e);
            throw e;
        }
    }
}
