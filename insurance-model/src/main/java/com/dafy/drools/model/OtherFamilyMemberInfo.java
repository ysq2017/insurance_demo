package com.dafy.drools.model;


/**
 * @author yangshaoqiang
 * @date 2018/10/11 15:31
 *
 * 除本人外家庭成员情况
 */
public class OtherFamilyMemberInfo {

    /**
     * 家庭人数
     */
    private Integer familySize;

    /**
     * 老人的人数
     */
    private Integer oldManSize;

    /**
     * 子女的人数
     */
    private Integer childrenSize;

    /**
     * 无收入子女的人数，默认20岁以下视为无收入
     */
    private Integer noIncomeChildrenSize;

    /**
     * 家庭压力指数(根据家庭人数和收入情况设计一个公式计算)
     */
    private Integer familyStress;


    public Integer getFamilySize() {
        return familySize;
    }

    public void setFamilySize(Integer familySize) {
        this.familySize = familySize;
    }

    public Integer getOldManSize() {
        return oldManSize;
    }

    public void setOldManSize(Integer oldManSize) {
        this.oldManSize = oldManSize;
    }

    public Integer getChildrenSize() {
        return childrenSize;
    }

    public void setChildrenSize(Integer childrenSize) {
        this.childrenSize = childrenSize;
    }

    public Integer getNoIncomeChildrenSize() {
        return noIncomeChildrenSize;
    }

    public void setNoIncomeChildrenSize(Integer noIncomeChildrenSize) {
        this.noIncomeChildrenSize = noIncomeChildrenSize;
    }

    public Integer getFamilyStress() {
        return familyStress;
    }

    public void setFamilyStress(Integer familyStress) {
        this.familyStress = familyStress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OtherFamilyMemberInfo{");
        sb.append("\"familySize\":")
                .append(familySize);
        sb.append(",\"oldManSize\":")
                .append(oldManSize);
        sb.append(",\"childrenSize\":")
                .append(childrenSize);
        sb.append(",\"noIncomeChildrenSize\":")
                .append(noIncomeChildrenSize);
        sb.append(",\"familyStress\":")
                .append(familyStress);
        sb.append('}');
        return sb.toString();
    }
}
