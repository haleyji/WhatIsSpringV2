package com.example.wis2.app.v1;

import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 helloTraceV1;
    public void save(String itemId) {

        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV1.begin("OrderRepository.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception occurred!");
            }
            sleep(1000);

            helloTraceV1.end(traceStatus);
        } catch (Exception e) {
            helloTraceV1.exception(traceStatus, e);
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
