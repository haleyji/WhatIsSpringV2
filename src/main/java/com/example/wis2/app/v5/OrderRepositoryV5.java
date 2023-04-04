package com.example.wis2.app.v5;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.LogTrace;
import com.example.wis2.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {
    private final LogTrace threadLocalLogTrace;
    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<Void>(threadLocalLogTrace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("Exception occurred!");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
