package com.neo.drools.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.neo.drools.config.DroolsBeanFactory;
import com.neo.drools.constants.IndustryEnum;
import com.neo.drools.model.*;
import com.neo.drools.model.fact.InsuranceDetailResult;
import com.neo.drools.model.fact.InsuranceTypeResult;
import com.neo.drools.model.request.SelfInsuranceRequest;
import com.neo.drools.model.response.InsuranceRecommendResponse;
import com.neo.drools.service.RecommendInnerService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangshaoqiang
 * @date 2018/10/15 20:12
 */
@Service
public class RecommendInnerServiceImpl implements RecommendInnerService {

    @Override
    public String test(int income, int health, int industry){
        KieSession kSession;

        String PATH = "insuranceRules/insuranceCalc.xlsx";
//        String PATH = "D:\\tmp\\drools\\rules\\insuranceCalc.xlsx";


        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
        kSession = new DroolsBeanFactory().getKieSession(resource);

        FullRequest fullRequest = new FullRequest();
        //收入信息
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(income);

        SelfBaseInfo selfBaseInfo;
        // 健康信息
        SelfHealthInfo selfHealthInfo = new SelfHealthInfo();
        SelfHealthInfo.Health healthInfo = health == 0?SelfHealthInfo.Health.NO:SelfHealthInfo.Health.YES;
        selfHealthInfo.setHealth(healthInfo);
        //工作信息
        SelfWorkInfo selfWorkInfo = new SelfWorkInfo();
        IndustryEnum industryEnum = IndustryEnum.getByValue(industry);
        selfWorkInfo.setIndustry(industryEnum);


        fullRequest.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);
        fullRequest.setSelfHealthInfo(selfHealthInfo);
        fullRequest.setSelfWorkInfo(selfWorkInfo);
        fullRequest.setResults(new ArrayList<InsuranceTypeResult>());

        System.out.println(JSONObject.toJSONString(fullRequest));

        // 需要把规则所有参数统一传入（包括输入输出）
        kSession.insert(fullRequest);

        int ruleFiredCount = kSession.fireAllRules();
        kSession.dispose();

        System.out.println("触发了" + ruleFiredCount + "条规则");
        return JSONObject.toJSONString(fullRequest.getResults());
    }


    @Override
    public InsuranceRecommendResponse selfRecommend(SelfInsuranceRequest selfInsuranceRequest) {

        KieSession kSession;

        String PATH = "selfInsuranceRecommendRules/selfInsurance.xlsx";
//        String PATH = "D:\\tmp\\drools\\rules\\insuranceCalc.xlsx";

        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
        kSession = new DroolsBeanFactory().getKieSession(resource);

        InsuranceRecommendResponse response = new InsuranceRecommendResponse();

        kSession.setGlobal("resp", response);
        kSession.insert(selfInsuranceRequest);

        int ruleFiredCount = kSession.fireAllRules();
        kSession.dispose();

        System.out.println("触发了" + ruleFiredCount + "条规则");
        System.out.println("resp:大类: " + JSONObject.toJSONString(response.getInsuranceTypeResultList()));

        return response;
    }





    public static InsuranceRecommendResponse selfRecommendTest(SelfInsuranceRequest selfInsuranceRequest) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("ks-selfRecommend");

//        String PATH = "selfInsuranceRecommendRules/selfInsurance.xlsx";
//        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
//        kSession = new DroolsBeanFactory().getKieSession(resource);

        InsuranceRecommendResponse response = new InsuranceRecommendResponse();
        kSession.setGlobal("resp", response);

        InsuranceTypeResult result2 = new InsuranceTypeResult();
        kSession.setGlobal("res2", result2);

        kSession.insert(selfInsuranceRequest);

        int ruleFiredCount = kSession.fireAllRules();
        kSession.dispose();

        System.out.println("触发了" + ruleFiredCount + "条规则");
        System.out.println("resp:大类: " + JSONObject.toJSONString(response.getInsuranceTypeResultList()));

        return response;
    }

    public static void main(String[] args) {
        SelfInsuranceRequest request = new SelfInsuranceRequest();
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(5);
        request.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);


        InsuranceRecommendResponse resp = selfRecommendTest(request);

        test();
    }
    static void test(){
        SelfInsuranceRequest req = new SelfInsuranceRequest();
        FamilyIncomeExpenseInfo fiei = req.getFamilyIncomeExpenseInfo();
//        fiei.getFamilyIncome();

        List<InsuranceTypeResult> insuranceTypeResultList = new ArrayList<>();
        InsuranceTypeResult result = new InsuranceTypeResult();
        result.setAmount(150);
        insuranceTypeResultList.add(result);
        List<InsuranceDetailResult> detailResults = new ArrayList<>();
        InsuranceDetailResult detailResult = new InsuranceDetailResult();
        detailResult.setAmount(150);
        detailResults.add(detailResult);

        InsuranceRecommendResponse resp = new InsuranceRecommendResponse();
        resp.addInsuranceTypeResultList(insuranceTypeResultList);
        resp.addInsuranceDetailResultList(detailResults);
        System.out.println("resp:大类: " + JSONObject.toJSONString(resp.getInsuranceTypeResultList()));
    }
}
