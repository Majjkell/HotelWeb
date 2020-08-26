package hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String displayMainPage(){
        return "index";
    }
}
