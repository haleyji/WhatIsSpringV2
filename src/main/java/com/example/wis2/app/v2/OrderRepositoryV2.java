package com.example.wis2.app.v2;

import com.example.wis2.trace.TraceId;
import com.example.wis2.trace.TraceStatus;
import com.example.wis2.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 helloTraceV2;
    public void save(TraceId traceId, String itemId) {

        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV2.beginSync(traceId,"OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception occurred!");
            }
            sleep(1000);

            helloTraceV2.end(traceStatus);
        } catch (Exception e) {
            helloTraceV2.exception(traceStatus, e);
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
