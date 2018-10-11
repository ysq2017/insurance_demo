package com.neo.drools.point;

import com.google.common.collect.Lists;
import com.neo.drools.model.*;
import com.neo.drools.model.fact.InsuranceResult;
import com.neo.drools.model.fact.Result;
import jdk.nashorn.internal.objects.annotations.Function;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class clacInsuranceXls {

    static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("ks-insuranceXLS");
    }

    public static void main(String[] args) {
        KieSession kSession = getSession();

        FullRequest fullRequest = new FullRequest();
        Result result = new Result();
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(10);
        fullRequest.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);
        FamilyMemberInfo familyMemberInfo;
        SelfBaseInfo selfBaseInfo;
        SelfHealthInfo selfHealthInfo;
        SelfWorkInfo selfWorkInfo;

        InsuranceResult insuranceResult = new InsuranceResult();
//        insuranceResult.setScore(10);
        fullRequest.setInsuranceResult(insuranceResult);

        // 需要把规则所有参数统一传入（包括输入输出）
        kSession.insert(fullRequest);

        int ruleFiredCount = kSession.fireAllRules();
        kSession.dispose();

        System.out.println("触发了" + ruleFiredCount + "条规则");


    }



}
