package com.bhashitha.springBootApiTemplate.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class cricketCoach implements coach{

    @Override
    public String name() {
        return "cldsdsassdf name is "+ getClass().getSimpleName();
    }
}
