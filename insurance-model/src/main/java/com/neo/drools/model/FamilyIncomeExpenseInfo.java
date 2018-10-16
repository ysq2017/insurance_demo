package com.neo.drools.model;

import com.neo.drools.constants.ExpenseTypeEnum;
import com.neo.drools.constants.IncomeTypeEnum;

import java.util.List;

/**
 * @author yangshaoqiang
 * @date 2018/10/11 15:31
 *
 * 家庭收支
 */
public class FamilyIncomeExpenseInfo {

    /**
     * 家庭总收入
     */
    private Integer familyIncome;

    /**
     * 收入类型
     */
    private List<IncomeTypeEnum> incomeTypeList;

    /**
     * 家庭总支出
     */
    private Integer familyExpense;

    /**
     * 支出类型
     */
    private List<ExpenseTypeEnum> expenseTypeList;

    /**
     * 家庭净收入:家庭总收入-家庭总支出
     */
    private Integer netIncome;

    /**
     * 家庭支柱收入占比（0-100）
     */
    private Integer breadwinnerIncomeRatio;

    public Integer getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(Integer familyIncome) {
        this.familyIncome = familyIncome;
    }

    public List<IncomeTypeEnum> getIncomeTypeList() {
        return incomeTypeList;
    }

    public void setIncomeTypeList(List<IncomeTypeEnum> incomeTypeList) {
        this.incomeTypeList = incomeTypeList;
    }

    public Integer getFamilyExpense() {
        return familyExpense;
    }

    public void setFamilyExpense(Integer familyExpense) {
        this.familyExpense = familyExpense;
    }

    public List<ExpenseTypeEnum> getExpenseTypeList() {
        return expenseTypeList;
    }

    public void setExpenseTypeList(List<ExpenseTypeEnum> expenseTypeList) {
        this.expenseTypeList = expenseTypeList;
    }

    public Integer getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Integer netIncome) {
        this.netIncome = netIncome;
    }

    public Integer getBreadwinnerIncomeRatio() {
        return breadwinnerIncomeRatio;
    }

    public void setBreadwinnerIncomeRatio(Integer breadwinnerIncomeRatio) {
        this.breadwinnerIncomeRatio = breadwinnerIncomeRatio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FamilyIncomeExpenseInfo{");
        sb.append("\"familyIncome\":")
                .append(familyIncome);
        sb.append(",\"incomeTypeList\":")
                .append(incomeTypeList);
        sb.append(",\"familyExpense\":")
                .append(familyExpense);
        sb.append(",\"expenseTypeList\":")
                .append(expenseTypeList);
        sb.append(",\"netIncome\":")
                .append(netIncome);
        sb.append(",\"breadwinnerIncomeRatio\":")
                .append(breadwinnerIncomeRatio);
        sb.append('}');
        return sb.toString();
    }
}
