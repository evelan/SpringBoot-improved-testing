package me.jpomykala.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Evelan on 23/10/2016.
 */
@Controller
public class HomeController {

//    @Autowired
//    MoonService moonService;

    @GetMapping(value = "/home", produces = "text/plain")
    public
    @ResponseBody
    String home() {
        return "Hello";
    }


//    @GetMapping(value = "/moon-temperature", produces = "text/plain")
//    public
//    @ResponseBody
//    String showTemperature() {
//        return String.valueOf(moonService.getTemperature());
//    }


}
