package com.example.springstart;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("helloDecorator")
public class HelloDecorator implements HelloService {

    private final HelloService helloService;


    public HelloDecorator(@Qualifier("simpleHelloService") HelloService helloService){
        this.helloService = helloService;
    }
    @Override
    public String sayHello(String name) {

        return  "*" + helloService.sayHello(name) + "*";
    }
}
