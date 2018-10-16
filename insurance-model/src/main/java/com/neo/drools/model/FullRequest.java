package com.neo.drools.model;

import com.neo.drools.model.fact.InsuranceTypeResult;

import java.util.List;

/**
 * @author yangshaoqiang
 * @date 2018/10/11 16:21
 *
 * 综和所有问题
 */
public class FullRequest {

    private FamilyIncomeExpenseInfo familyIncomeExpenseInfo;


    private SelfBaseInfo selfBaseInfo;

    private SelfHealthInfo selfHealthInfo;

    private SelfWorkInfo selfWorkInfo;

    private List<InsuranceTypeResult> results;

    private InsuranceTypeResult insuranceTypeResult;

    public FamilyIncomeExpenseInfo getFamilyIncomeExpenseInfo() {
        return familyIncomeExpenseInfo;
    }

    public void setFamilyIncomeExpenseInfo(FamilyIncomeExpenseInfo familyIncomeExpenseInfo) {
        this.familyIncomeExpenseInfo = familyIncomeExpenseInfo;
    }


    public SelfBaseInfo getSelfBaseInfo() {
        return selfBaseInfo;
    }

    public void setSelfBaseInfo(SelfBaseInfo selfBaseInfo) {
        this.selfBaseInfo = selfBaseInfo;
    }

    public SelfHealthInfo getSelfHealthInfo() {
        return selfHealthInfo;
    }

    public void setSelfHealthInfo(SelfHealthInfo selfHealthInfo) {
        this.selfHealthInfo = selfHealthInfo;
    }

    public SelfWorkInfo getSelfWorkInfo() {
        return selfWorkInfo;
    }

    public void setSelfWorkInfo(SelfWorkInfo selfWorkInfo) {
        this.selfWorkInfo = selfWorkInfo;
    }

    public List<InsuranceTypeResult> getResults() {
        return results;
    }

    public void setResults(List<InsuranceTypeResult> results) {
        this.results = results;
    }

    public void addResults(List<InsuranceTypeResult> results) {
        this.results.addAll(results);
    }

    public InsuranceTypeResult getInsuranceTypeResult() {
        return insuranceTypeResult;
    }

    public void setInsuranceTypeResult(InsuranceTypeResult insuranceTypeResult) {
        this.insuranceTypeResult = insuranceTypeResult;
    }
}
