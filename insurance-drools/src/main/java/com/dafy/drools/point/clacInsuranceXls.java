package com.dafy.drools.point;

import com.dafy.drools.model.*;
import com.dafy.drools.constants.IndustryEnum;
import com.dafy.drools.model.fact.InsuranceTypeResult;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;

public class clacInsuranceXls {

    static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("ks-insuranceXLS");
    }

    public static void main(String[] args) {
        KieSession kSession = getSession();

        FullRequest fullRequest = new FullRequest();
        //收入信息
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(6);

        SelfBaseInfo selfBaseInfo;
        // 健康信息
        SelfHealthInfo selfHealthInfo = new SelfHealthInfo();
        selfHealthInfo.setHealth(SelfHealthInfo.Health.NO);
        //工作信息
        SelfWorkInfo selfWorkInfo = new SelfWorkInfo();
        selfWorkInfo.setIndustry(IndustryEnum.OUTDOOR);


        fullRequest.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);
        fullRequest.setSelfHealthInfo(selfHealthInfo);
        fullRequest.setSelfWorkInfo(selfWorkInfo);
        fullRequest.setResults(new ArrayList<InsuranceTypeResult>());

        InsuranceTypeResult result = new InsuranceTypeResult();
        InsuranceTypeResult result2 = new InsuranceTypeResult();

        // setGlobal 可以传输出参数进入ACTION
        kSession.setGlobal("res", result);
        kSession.setGlobal("res2", result2);
        // 需要把规则所有参数统一传入（包括输入输出）
        kSession.insert(fullRequest);

        int ruleFiredCount = kSession.fireAllRules();
        kSession.dispose();

        System.out.println("触发了" + ruleFiredCount + "条规则");

    }



}
