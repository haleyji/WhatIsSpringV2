package com.example.wis2.app.v2;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 helloTraceV2;
    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV2.begin("OrderController.request()");
            orderService.orderItem(traceStatus.getTraceId(), itemId);
            helloTraceV2.end(traceStatus);
            return "ok";
        } catch (Exception e) {
            helloTraceV2.exception(traceStatus, e);
            throw e;
        }
    }
}
