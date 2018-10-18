package com.dafy.drools.model.response;


import com.dafy.drools.constants.LabelAgeEnum;
import com.dafy.drools.constants.LabelExpenseTypeEnum;
import com.dafy.drools.constants.LabelIncomeEnum;
import com.dafy.drools.constants.LabelIncomeTypeEnum;
import com.dafy.drools.model.fact.InsuranceTypeResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangshaoqiang
 * @date 2018/10/18 15:21
 *
 * 生成报告
 */
public class ReportResponse {

    /**
     * 家庭成员标签  *口之家
     */
    private String familyMember;

    /**
     * 年龄
     */
    private LabelAgeEnum labelAgeEnum;

    /**
     * 收入阶层
     */
    private LabelIncomeEnum incomeEnum;

    /**
     * 收入类别标签
     */
    private List<LabelIncomeTypeEnum> labelIncomeTypeList;

    /**
     * 支出类别标签
     */
    private List<LabelExpenseTypeEnum> labelExpenseTypeList;


    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public LabelAgeEnum getLabelAgeEnum() {
        return labelAgeEnum;
    }

    public void setLabelAgeEnum(LabelAgeEnum labelAgeEnum) {
        this.labelAgeEnum = labelAgeEnum;
    }

    public LabelIncomeEnum getIncomeEnum() {
        return incomeEnum;
    }

    public void setIncomeEnum(LabelIncomeEnum incomeEnum) {
        this.incomeEnum = incomeEnum;
    }

    public List<LabelIncomeTypeEnum> getLabelIncomeTypeList() {
        return labelIncomeTypeList;
    }

    public void setLabelIncomeTypeList(List<LabelIncomeTypeEnum> labelIncomeTypeList) {
        this.labelIncomeTypeList = labelIncomeTypeList;
    }

    public void addLabelIncomeTypeList(List<LabelIncomeTypeEnum> labelIncomeTypeList) {
        if(this.labelIncomeTypeList == null) {
            this.labelIncomeTypeList = new ArrayList<>();
            this.labelIncomeTypeList.addAll(labelIncomeTypeList);
        } else {
            this.labelIncomeTypeList.addAll(labelIncomeTypeList);
        }
    }

    public List<LabelExpenseTypeEnum> getLabelExpenseTypeList() {
        return labelExpenseTypeList;
    }

    public void setLabelExpenseTypeList(List<LabelExpenseTypeEnum> labelExpenseTypeList) {
        this.labelExpenseTypeList = labelExpenseTypeList;
    }

    public void addLabelExpenseTypeList(List<LabelExpenseTypeEnum> labelExpenseTypeList) {
        if(this.labelExpenseTypeList == null) {
            this.labelExpenseTypeList = new ArrayList<>();
            this.labelExpenseTypeList.addAll(labelExpenseTypeList);
        } else {
            this.labelExpenseTypeList.addAll(labelExpenseTypeList);
        }
    }

}
