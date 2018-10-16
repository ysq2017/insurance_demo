package com.neo.drools.model;

import com.neo.drools.constants.FamilyRoleEnum;

/**
 * @author yangshaoqiang
 * @date 2018/10/11 15:42
 */
public class FamilyMember {

    /**
     * 家庭角色
     */
    private FamilyRoleEnum role;

    /**
     * 是否是家庭支柱
     */
    private Integer isBreadwinner;

    /**
     * 在家庭总收入中的占比（0-100）
     * 家庭支柱或非家庭支柱的收入总占比除以人数
     * 20岁以下的子女默认无收入
     */
    private Integer incomeRatio;

    /**
     * 成员年龄。
     * 配偶：推算同本人
     * 子女：精确输入
     * 父母：本人+25
     */
    private Integer age;

    public FamilyRoleEnum getRole() {
        return role;
    }

    public void setRole(FamilyRoleEnum role) {
        this.role = role;
    }

    public Integer getIsBreadwinner() {
        return isBreadwinner;
    }

    public void setIsBreadwinner(Integer isBreadwinner) {
        this.isBreadwinner = isBreadwinner;
    }

    public Integer getIncomeRatio() {
        return incomeRatio;
    }

    public void setIncomeRatio(Integer incomeRatio) {
        this.incomeRatio = incomeRatio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FamilyMember{");
        sb.append("\"role\":")
                .append(role);
        sb.append(",\"isBreadwinner\":")
                .append(isBreadwinner);
        sb.append(",\"incomeRatio\":")
                .append(incomeRatio);
        sb.append(",\"age\":")
                .append(age);
        sb.append('}');
        return sb.toString();
    }
}
