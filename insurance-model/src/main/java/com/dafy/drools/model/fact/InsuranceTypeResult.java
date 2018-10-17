package com.dafy.drools.model.fact;

import com.dafy.drools.constants.InsuranceTypeEnum;

/**
 * @author yangshaoqiang
 * @date 2018/10/11 15:48
 */
public class InsuranceTypeResult {

    /**
     * 推荐指数
     */
    private int score;

    /**
     * 推荐购买金额
     */
    private int amount;

    public InsuranceTypeResult(int score, int amount, InsuranceTypeEnum insuranceTypeEnum) {
        this.score = score;
        this.amount = amount;
        this.insuranceTypeEnum = insuranceTypeEnum;
    }

    public InsuranceTypeResult(int score, InsuranceTypeEnum insuranceTypeEnum) {
        this.score = score;
        this.insuranceTypeEnum = insuranceTypeEnum;
    }

    public InsuranceTypeResult() {
    }

    private InsuranceTypeEnum insuranceTypeEnum;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public InsuranceTypeEnum getInsuranceTypeEnum() {
        return insuranceTypeEnum;
    }

    public void setInsuranceTypeEnum(InsuranceTypeEnum insuranceTypeEnum) {
        this.insuranceTypeEnum = insuranceTypeEnum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InsuranceTypeResult{");
        sb.append("\"score\":")
                .append(score);
        sb.append(",\"amount\":")
                .append(amount);
        sb.append(",\"insuranceTypeEnum\":")
                .append(insuranceTypeEnum);
        sb.append('}');
        return sb.toString();
    }

}
