package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
       
        model.addAttribute("name", "สโรชา เสาทอง");
        model.addAttribute("studentId", "673380296-7");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("bio", "ยินดีต้อน! ดิฉันเป็นนักศึกษา CP353002 กำลังศึกษาเรื่อง Custom ViewResolver ใน Spring Boot");
        return "about"; 
    }
    
}