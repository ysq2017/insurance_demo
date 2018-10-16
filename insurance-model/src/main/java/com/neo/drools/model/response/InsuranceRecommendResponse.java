package com.neo.drools.model.response;

import com.neo.drools.model.fact.InsuranceDetailResult;
import com.neo.drools.model.fact.InsuranceTypeResult;

import java.util.List;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 16:21
 *
 * 保险推荐结果
 */
public class InsuranceRecommendResponse {

    /**
     * 大类列表
     */
    private List<InsuranceTypeResult> insuranceTypeResultList;

    /**
     * 详细列表
     */
    private List<InsuranceDetailResult> insuranceDetailResultList;

    public List<InsuranceTypeResult> getInsuranceTypeResultList() {
        return insuranceTypeResultList;
    }

    public void setInsuranceTypeResultList(List<InsuranceTypeResult> insuranceTypeResultList) {
        this.insuranceTypeResultList = insuranceTypeResultList;
    }

    public List<InsuranceDetailResult> getInsuranceDetailResultList() {
        return insuranceDetailResultList;
    }

    public void setInsuranceDetailResultList(List<InsuranceDetailResult> insuranceDetailResultList) {
        this.insuranceDetailResultList = insuranceDetailResultList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InsuranceRecommendResponse{");
        sb.append("\"insuranceTypeResultList\":")
                .append(insuranceTypeResultList);
        sb.append(",\"insuranceDetailResultList\":")
                .append(insuranceDetailResultList);
        sb.append('}');
        return sb.toString();
    }
}
