package com.naba.tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/","home"})
    public String displayHomePage(){
String name="Nasir";

        if(name.equalsIgnoreCase("Nasir")) {
            return "home.html";
        }else {
            return "home.html";
        }
    }
}
