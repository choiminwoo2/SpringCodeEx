package com.example.springstart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    void helloController() {
        FrontController frontController = new FrontController(name -> name);

        String ret = frontController.hello("Test");

        assertEquals(ret, "Test");
    }
}
