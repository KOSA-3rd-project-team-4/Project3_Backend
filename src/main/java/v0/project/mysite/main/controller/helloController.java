package v0.project.mysite.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController{

    @GetMapping(value = "/hello")
    public String helloSpring() {
        return "index";
    }
}
