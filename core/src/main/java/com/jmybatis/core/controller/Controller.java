package com.jmybatis.core.controller;

import com.jmybatis.core.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OneService oneService;


    @GetMapping("/e")
    public String e() {
        String name = oneService.getOneUser().getName();
        return "e,server e method,name = " + name;
    }

}
