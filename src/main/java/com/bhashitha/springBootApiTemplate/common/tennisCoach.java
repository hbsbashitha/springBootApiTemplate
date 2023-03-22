package com.bhashitha.springBootApiTemplate.common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements coach{
    @Override
    public String name() {
        return "class name is "+ getClass().getSimpleName();
    }
}
