package com.neo.drools.controller;

import com.neo.drools.service.RulesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;


@RequestMapping("/test")
@Controller
public class TestController {

    @Resource
    private RulesService rulesService;

    @ResponseBody
    @RequestMapping("/insurance")
    public String test(@RequestParam int income, @RequestParam int health, @RequestParam int industry){


        return rulesService.test(income, health, industry);
    }

}
