package com.yusuf.recipeOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomepageController {

    @GetMapping("/homepage")
    public String homepage() {
        return "homepage";
    }


}
