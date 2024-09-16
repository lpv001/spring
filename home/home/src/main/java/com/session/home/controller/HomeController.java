package com.session.home.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("myList", Arrays.asList("item1", "item2", "item3"));
        return "index";
    }
}
