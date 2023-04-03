package com.example.wis2.app.v3;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.FieldLogTrace;
import com.example.wis2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace fieldLogTrace;
    public void orderItem(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = fieldLogTrace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            fieldLogTrace.end(traceStatus);
        } catch (Exception e) {
            fieldLogTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
