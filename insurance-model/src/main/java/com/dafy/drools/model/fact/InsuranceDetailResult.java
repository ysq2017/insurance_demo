package com.dafy.drools.model.fact;

import com.dafy.drools.constants.InsuranceTypeEnum;

/**
 * @author yangshaoqiang
 * @date 2018/10/11 15:48
 */
public class InsuranceDetailResult {

    /**
     * 推荐指数
     */
    private int score;

    /**
     * 推荐购买金额
     */
    private int amount;

    private InsuranceTypeEnum.InsuranceDetailEnum insuranceDetailEnum;

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

    public InsuranceTypeEnum.InsuranceDetailEnum getInsuranceDetailEnum() {
        return insuranceDetailEnum;
    }

    public void setInsuranceDetailEnum(InsuranceTypeEnum.InsuranceDetailEnum insuranceDetailEnum) {
        this.insuranceDetailEnum = insuranceDetailEnum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InsuranceDetailResult{");
        sb.append("\"score\":")
                .append(score);
        sb.append(",\"amount\":")
                .append(amount);
        sb.append(",\"insuranceDetailEnum\":")
                .append(insuranceDetailEnum);
        sb.append('}');
        return sb.toString();
    }

}
