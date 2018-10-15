package com.neo.drools.controller;

import com.alibaba.fastjson.JSONObject;
import com.neo.drools.config.DroolsBeanFactory;
import com.neo.drools.dao.Order;
import com.neo.drools.dao.User;
import com.neo.drools.model.*;
import com.neo.drools.model.fact.InsuranceResult;
import com.neo.drools.service.RecommendInnerService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;


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
