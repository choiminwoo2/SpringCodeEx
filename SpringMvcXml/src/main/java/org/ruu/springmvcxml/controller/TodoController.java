package org.ruu.springmvcxml.controller;

import lombok.extern.log4j.Log4j2;
import org.ruu.springmvcxml.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @GetMapping("/list")
    public void list(){
        log.info("todo List");
    }

    @GetMapping("/register")
    public void registerGet(){
        log.info("GetTodos regis");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO){
        log.info("Post todo regis");
    }



}
