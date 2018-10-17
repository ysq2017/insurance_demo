package com.dafy.drools.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dafy.drools.model.*;
import com.dafy.drools.service.RecommendInnerService;
import com.dafy.drools.config.DroolsBeanFactory;
import com.dafy.drools.constants.IndustryEnum;
import com.dafy.drools.model.fact.InsuranceDetailResult;
import com.dafy.drools.model.fact.InsuranceTypeResult;
import com.dafy.drools.model.request.SelfInsuranceRequest;
import com.dafy.drools.model.response.InsuranceRecommendResponse;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangshaoqiang
 * @date 2018/10/15 20:12
 */
@Service
public class RecommendInnerServiceImpl implements RecommendInnerService {
    private KieContainer kContainer;

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

    @PostConstruct
    public void setUp() {
        KieServices ks = KieServices.Factory.get();

        ReleaseId releaseId = ks.newReleaseId("com.dafy.insurance", "insurance-rules", "0.0.1-SNAPSHOT");

        kContainer = ks.newKieContainer(releaseId);
        KieScanner kScanner = ks.newKieScanner(kContainer);

        // Start the KieScanner polling the Maven repository every 10 seconds
        kScanner.start(10000L);
    }


    @Override
    public InsuranceRecommendResponse selfRecommend(SelfInsuranceRequest selfInsuranceRequest) {
        KieSession kSession;

//        String PATH = "selfInsuranceRecommendRules/selfInsurance.xlsx";
//        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
//        kSession = new DroolsBeanFactory().getKieSession(resource);

        kSession = kContainer.newKieSession("ks-selfRecommend");


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





///////////////////////////////////////

    public static InsuranceRecommendResponse selfRecommendTest(SelfInsuranceRequest selfInsuranceRequest) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("ks-selfRecommend");

//        KieSession kSession = kContainer.newKieSession("ksession1");

//        String PATH = "selfInsuranceRecommendRules/selfInsurance.xlsx";
//        org.kie.api.io.Resource resource = ResourceFactory.newClassPathResource(PATH, getClass());
//        KieSession kSession = new DroolsBeanFactory().getKieSession(resource);

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
