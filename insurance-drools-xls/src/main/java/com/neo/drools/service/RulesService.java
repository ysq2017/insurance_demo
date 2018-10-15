package com.neo.drools.service;

import com.alibaba.fastjson.JSONObject;
import com.neo.drools.config.DroolsBeanDynamicFactory;
import com.neo.drools.config.DroolsBeanFactory;
import com.neo.drools.model.*;
import com.neo.drools.model.fact.InsuranceResult;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * @author: yangshaoqiang
 * @date: 2018/10/15 21:50
 */
@Service
public class RulesService {

//    @PostConstruct
//    public void setUp() {
//        KieServices ks = KieServices.Factory.get();
//
//        ReleaseId releaseId = ks.newReleaseId("com.secbro", "insurance-rules", "0.0.1-SNAPSHOT");
//
//        kContainer = ks.newKieContainer(releaseId);
//        KieScanner kScanner = ks.newKieScanner(kContainer);
//
//        // Start the KieScanner polling the Maven repository every 10 seconds
//        kScanner.start(10000L);
//    }

    static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("ks-insuranceXLS");
    }

    public String test(int income, int health, int industry){

        KieSession kSession = getSession();

//        String PATH = "insuranceRules/insuranceCalc.xlsx";
//        String PATH = "D:\\tmp\\drools\\rules\\insuranceCalc.xlsx";


//        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
//        KieSession kSession = new DroolsBeanFactory().getKieSession(resource);

//        kContainer = new DroolsBeanFactory().getKieSession();
//        kSession = kieContainer.newKieSession("ks");


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
