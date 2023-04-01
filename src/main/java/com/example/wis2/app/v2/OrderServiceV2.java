package com.example.wis2.app.v2;

import com.example.wis2.trace.TraceId;
import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 helloTraceV2;
    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV2.beginSync(traceId,"OrderService.orderItem()");
            orderRepository.save(traceStatus.getTraceId(), itemId);
            helloTraceV2.end(traceStatus);
        } catch (Exception e) {
            helloTraceV2.exception(traceStatus, e);
            throw e;
        }
    }
}
