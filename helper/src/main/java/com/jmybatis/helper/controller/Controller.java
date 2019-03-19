package com.jmybatis.helper.controller;

import com.jmybatis.helper.entity.User;
import com.jmybatis.helper.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private OneService oneService;


    @GetMapping("/e")
    public String e() {
        String name = oneService.getOneUser().getName();
        return "e,server e method,name = " + name;
    }

    @GetMapping("/h")
    public List<User> getUsers(){
        return oneService.getUsers();
    }

}
