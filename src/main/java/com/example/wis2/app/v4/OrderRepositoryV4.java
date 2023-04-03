package com.example.wis2.app.v4;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
    private final LogTrace threadLocalLogTrace;
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = threadLocalLogTrace.begin("OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception occurred!");
            }
            sleep(1000);
            threadLocalLogTrace.end(status);
        } catch (Exception e) {
            threadLocalLogTrace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
