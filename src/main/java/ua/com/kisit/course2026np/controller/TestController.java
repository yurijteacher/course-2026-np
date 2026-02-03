package ua.com.kisit.course2026np.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hello", "Hello World!!!");
        return "index";
    }


}
