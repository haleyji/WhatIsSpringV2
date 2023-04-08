package com.example.wis2.app.v6;

import com.example.wis2.trace.callback.TraceTemplate;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepositoryV6 {
    private final TraceTemplate traceTemplate;

    public OrderRepositoryV6(LogTrace threadLocalLogTrace) {
        this.traceTemplate = new TraceTemplate(threadLocalLogTrace);
    }

    public void save(String itemId) {
        traceTemplate.execute("OrderRepository.save()",() -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception occurred!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
