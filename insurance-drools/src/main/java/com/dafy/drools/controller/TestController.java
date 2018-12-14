package com.dafy.drools.controller;

import com.dafy.drools.model.FamilyIncomeExpenseInfo;
import com.dafy.drools.model.SelfHealthInfo;
import com.dafy.drools.service.RecommendInnerService;
import com.dafy.drools.model.request.SelfInsuranceRequest;
import com.dafy.drools.model.response.InsuranceRecommendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @ResponseBody
    @RequestMapping("/test")
    public InsuranceRecommendResponse test(@RequestBody SelfInsuranceRequest request){

        return recommendInnerService.selfRecommend(request);

    }

}
