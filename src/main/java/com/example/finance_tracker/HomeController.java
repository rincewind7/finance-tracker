package com.example.finance_tracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//testowa klasa do wyświetlania
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        String viewName = getViewName();
        return viewName;
    }

    private String getViewName() {
        return "index.html";
    }
}
