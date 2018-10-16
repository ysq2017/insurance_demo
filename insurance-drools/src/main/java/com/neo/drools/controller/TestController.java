package com.neo.drools.controller;

import com.neo.drools.service.RecommendInnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@RequestMapping("/test")
@Controller
public class TestController {

//    @Resource
//    private KieContainer kieContainer;

    @Autowired
    private RecommendInnerService recommendInnerService;

    @ResponseBody
    @RequestMapping("/insurance")
    public String test(@RequestParam int income, @RequestParam int health, @RequestParam int industry){

        return recommendInnerService.test(income, health, industry);

    }

}
