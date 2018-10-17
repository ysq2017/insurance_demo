package com.dafy.drools.model.request;

import com.dafy.drools.model.*;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 16:21
 *
 * 本人推荐所需参数
 */
public class SelfInsuranceRequest {

    /**
     * 家庭收入情况
     */
    private FamilyIncomeExpenseInfo familyIncomeExpenseInfo;

    /**
     * 其他家庭成员情况
     */
    private OtherFamilyMemberInfo otherFamilyMemberInfo;

    /**
     * 本人的家庭角色信息
     */
    private FamilyMember familyMember;

    private SelfBaseInfo selfBaseInfo;

    private SelfHealthInfo selfHealthInfo;

    private SelfWorkInfo selfWorkInfo;


    public FamilyIncomeExpenseInfo getFamilyIncomeExpenseInfo() {
        return familyIncomeExpenseInfo;
    }

    public void setFamilyIncomeExpenseInfo(FamilyIncomeExpenseInfo familyIncomeExpenseInfo) {
        this.familyIncomeExpenseInfo = familyIncomeExpenseInfo;
    }

    public OtherFamilyMemberInfo getOtherFamilyMemberInfo() {
        return otherFamilyMemberInfo;
    }

    public void setOtherFamilyMemberInfo(OtherFamilyMemberInfo otherFamilyMemberInfo) {
        this.otherFamilyMemberInfo = otherFamilyMemberInfo;
    }

    public FamilyMember getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(FamilyMember familyMember) {
        this.familyMember = familyMember;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SelfInsuranceRequest{");
        sb.append("\"familyIncomeExpenseInfo\":")
                .append(familyIncomeExpenseInfo);
        sb.append(",\"otherFamilyMemberInfo\":")
                .append(otherFamilyMemberInfo);
        sb.append(",\"familyMember\":")
                .append(familyMember);
        sb.append(",\"selfBaseInfo\":")
                .append(selfBaseInfo);
        sb.append(",\"selfHealthInfo\":")
                .append(selfHealthInfo);
        sb.append(",\"selfWorkInfo\":")
                .append(selfWorkInfo);
        sb.append('}');
        return sb.toString();
    }
}
