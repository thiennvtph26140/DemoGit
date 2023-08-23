package com.example.demo_java6.bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

    @RequestMapping("/home/index")
    public String hienThiMes (Model model){
        model.addAttribute("mess", "FPT<b>polytechnic</b>");
        return "bai2/index";
    }
}
