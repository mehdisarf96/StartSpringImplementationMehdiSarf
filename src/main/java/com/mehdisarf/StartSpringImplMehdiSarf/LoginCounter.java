package com.mehdisarf.StartSpringImplMehdiSarf;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class LoginCounter {

    private long counter; // niazi be static nis chon be per App, yeki sakhte mishe khodesh.

    public long getCounter() {
        return counter;
    }

    public void increment() {
        counter++;
    }
}
