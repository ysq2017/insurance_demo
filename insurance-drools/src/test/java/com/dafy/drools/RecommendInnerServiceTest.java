package com.dafy.drools;

import com.dafy.drools.config.DroolsBeanFactory;
import com.dafy.drools.constants.ExpenseTypeEnum;
import com.dafy.drools.constants.IncomeTypeEnum;
import com.dafy.drools.model.FamilyIncomeExpenseInfo;
import com.dafy.drools.model.request.ReportRequest;
import com.dafy.drools.model.response.ReportResponse;
import com.dafy.drools.service.RecommendInnerService;
import com.dafy.drools.model.request.SelfInsuranceRequest;
import com.dafy.drools.model.response.InsuranceRecommendResponse;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author yangshaoqiang
 * @date 2018/10/17 16:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InsuranceDroolsXlsApplication.class)
public class RecommendInnerServiceTest {

    @Resource
    private RecommendInnerService recommendInnerService;

    @Test
    public void selfRecommend() {
        SelfInsuranceRequest request = new SelfInsuranceRequest();
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(5);
        familyIncomeExpenseInfo.setIncomeTypeList(Lists.newArrayList());
        request.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);

        InsuranceRecommendResponse resp = recommendInnerService.selfRecommend(request);
        System.out.println("resp"+resp);
    }

    @Test
    public void getReport() {
        ReportRequest request = new ReportRequest();
        FamilyIncomeExpenseInfo familyIncomeExpenseInfo = new FamilyIncomeExpenseInfo();
        familyIncomeExpenseInfo.setFamilyIncome(5);
        familyIncomeExpenseInfo.setIncomeTypeList(Lists.newArrayList(IncomeTypeEnum.INVEST));
        familyIncomeExpenseInfo.setExpenseTypeList(Lists.newArrayList(ExpenseTypeEnum.CAR_LOAN, ExpenseTypeEnum.HOME_LOAN));
        request.setFamilyIncomeExpenseInfo(familyIncomeExpenseInfo);

        ReportResponse resp = recommendInnerService.getReport(request);
        System.out.println("resp"+resp);
    }

    @Test
    public void getDrlString(){
        String PATH = "reportRules/reportRules.xlsx";

        String drl = new DroolsBeanFactory().getDrlFromExcel(PATH);
        System.out.println("drl: " + drl);
    }
}
