package com.example.wis2.app.v3;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.FieldLogTrace;
import com.example.wis2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace fieldLogTrace;


    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = fieldLogTrace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            fieldLogTrace.end(traceStatus);
            return "ok";
        } catch (Exception e) {
            fieldLogTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
