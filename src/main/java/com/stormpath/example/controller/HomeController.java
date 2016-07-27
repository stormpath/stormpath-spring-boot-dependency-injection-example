package com.stormpath.example.controller;

import com.stormpath.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    ApplicationContext appContext;

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/")
    public String home() {
        return greetingService.greet();
    }

    @RequestMapping("/beans")
    public @ResponseBody Map<String, String[]> beans(@RequestParam(required = false) String q) {
        Map<String, String[]> retMap = new HashMap<>();

        String[] retArray = Arrays.stream(appContext.getBeanDefinitionNames())
            .filter(beanName ->
                (q == null || q.length() == 0) ||
                beanName.toLowerCase().contains(q.trim().toLowerCase())
            )
            .toArray(String[]::new);

        retMap.put("beans", retArray);
        return retMap;
    }
}
