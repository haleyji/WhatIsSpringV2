package com.example.wis2.app.v3;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.logtrace.FieldLogTrace;
import com.example.wis2.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace fieldLogTrace;
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = fieldLogTrace.begin("OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception occurred!");
            }
            sleep(1000);
            fieldLogTrace.end(status);
        } catch (Exception e) {
            fieldLogTrace.exception(status, e);
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
