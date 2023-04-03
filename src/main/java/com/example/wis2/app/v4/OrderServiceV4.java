package com.example.wis2.app.v4;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace threadLocalLogTrace;
    public void orderItem(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = threadLocalLogTrace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            threadLocalLogTrace.end(traceStatus);
        } catch (Exception e) {
            threadLocalLogTrace.exception(traceStatus, e);
            throw e;
        }
    }
}
