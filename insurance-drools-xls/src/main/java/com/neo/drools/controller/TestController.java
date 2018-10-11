package com.neo.drools.controller;

import com.alibaba.fastjson.JSONObject;
import com.neo.drools.config.DroolsBeanFactory;
import com.neo.drools.dao.Order;
import com.neo.drools.dao.User;
import com.neo.drools.model.*;
import com.neo.drools.model.fact.InsuranceResult;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
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

    @ResponseBody
    @RequestMapping("/insurance")
    public String test(@RequestParam int income, @RequestParam int health, @RequestParam int industry){
        KieSession kSession;

        String PATH = "insuranceRules/insuranceCalc.xlsx";
//        String PATH = "D:\\tmp\\drools\\rules\\insuranceCalc.xlsx";


        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
        kSession = new DroolsBeanFactory().getKieSession(resource);

        FullRequest fullRequest = new FullRequest();
        //收入信息
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(income);

        FamilyMemberInfo familyMemberInfo;
        SelfBaseInfo selfBaseInfo;
        // 健康信息
        SelfHealthInfo selfHealthInfo = new SelfHealthInfo();
        SelfHealthInfo.Health healthInfo = health == 0?SelfHealthInfo.Health.NO:SelfHealthInfo.Health.YES;
        selfHealthInfo.setHealth(healthInfo);
        //工作信息
        SelfWorkInfo selfWorkInfo = new SelfWorkInfo();
        SelfWorkInfo.IndustryEnum industryEnum = SelfWorkInfo.IndustryEnum.getByValue(industry);
        selfWorkInfo.setIndustry(industryEnum);


        fullRequest.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);
        fullRequest.setSelfHealthInfo(selfHealthInfo);
        fullRequest.setSelfWorkInfo(selfWorkInfo);
        fullRequest.setResults(new ArrayList<InsuranceResult>());

        System.out.println(JSONObject.toJSONString(fullRequest));

        // 需要把规则所有参数统一传入（包括输入输出）
        kSession.insert(fullRequest);

        int ruleFiredCount = kSession.fireAllRules();
        kSession.dispose();

        System.out.println("触发了" + ruleFiredCount + "条规则");
        return JSONObject.toJSONString(fullRequest.getResults());

    }

}
