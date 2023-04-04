package com.example.wis2.app.v5;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final LogTrace threadLocalLogTrace;
    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(threadLocalLogTrace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            };
        };
        template.execute("OrderService.orderItem()");
    }
}
