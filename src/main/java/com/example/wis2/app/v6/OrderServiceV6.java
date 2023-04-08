package com.example.wis2.app.v6;

import com.example.wis2.trace.callback.TraceCallback;
import com.example.wis2.trace.callback.TraceTemplate;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV6 {

    private final OrderRepositoryV6 orderRepository;
    private final TraceTemplate traceTemplate;

    public OrderServiceV6(OrderRepositoryV6 orderRepository,  LogTrace threadLocalLogTrace) {
        this.orderRepository = orderRepository;
        this.traceTemplate = new TraceTemplate(threadLocalLogTrace);
    }

    public void orderItem(String itemId) {
        traceTemplate.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
