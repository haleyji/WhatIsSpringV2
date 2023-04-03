package com.example.wis2.app.v4;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace threadLocalLogTrace;
    @GetMapping("/v4/request")
    public String request(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = threadLocalLogTrace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            threadLocalLogTrace.end(traceStatus);
            return "ok";
        } catch (Exception e) {
            threadLocalLogTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
