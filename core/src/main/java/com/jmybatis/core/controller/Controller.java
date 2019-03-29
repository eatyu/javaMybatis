package com.jmybatis.core.controller;

import com.jmybatis.core.entity.User;
import com.jmybatis.core.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class Controller {

    @Autowired
    private OneService oneService;


    @GetMapping("/e")
    public String e() {
        String name = oneService.getOneUser().getName();
        return "e,server e method,name = " + name;
    }

    @GetMapping("/alle")
    public String alle(){
        List<User> allUser = oneService.getAllUser();
        if (allUser==null) {
            System.out.println("orz");
        } else {
            System.out.println(allUser.size());
        }
        return "ok";
    }

    /**
     * 获得当前域名
     */
    @PostMapping("/getDomainName")
    public String getDomainName(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
        return tempContextUrl;
    }

    /**
     * 获得当前域名
     */
    @PostMapping("/getDomainName2")
    public String getDomainName2(HttpServletRequest request) {

        StringBuffer url = request.getRequestURL();
        System.out.println("%%%" + url);
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        return tempContextUrl;
    }


}
