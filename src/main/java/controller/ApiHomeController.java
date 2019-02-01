package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class ApiHomeController {

    @RequestMapping
    @ResponseBody
    String home() {
        return "Hello API";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiHomeController.class, args);
    }
}
