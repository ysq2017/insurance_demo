package com.neo.drools.model;

/**
 * @author: yangshaoqiang
 * @date: 2018/10/11 15:31
 *
 * 家庭收支
 */
public class FamilyIncomeExpenseInfo {

    int familyIncome;

    Integer selfIncome;

    Integer familyExpense;

    public Integer getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(Integer familyIncome) {
        this.familyIncome = familyIncome;
    }

    public Integer getSelfIncome() {
        return selfIncome;
    }

    public void setSelfIncome(Integer selfIncome) {
        this.selfIncome = selfIncome;
    }

    public Integer getFamilyExpense() {
        return familyExpense;
    }

    public void setFamilyExpense(Integer familyExpense) {
        this.familyExpense = familyExpense;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FamilyIncomeExpenseInfo{");
        sb.append("\"familyIncome\":")
                .append(familyIncome);
        sb.append(",\"selfIncome\":")
                .append(selfIncome);
        sb.append(",\"familyExpense\":")
                .append(familyExpense);
        sb.append('}');
        return sb.toString();
    }
}
