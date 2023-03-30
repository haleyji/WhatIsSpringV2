package com.example.wis2.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("Exception occurred!");
        }
        sleep(1000);
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
