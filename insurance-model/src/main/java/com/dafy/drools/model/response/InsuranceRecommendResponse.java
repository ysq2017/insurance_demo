package com.dafy.drools.model.response;

import com.dafy.drools.model.fact.InsuranceTypeResult;
import com.dafy.drools.model.fact.InsuranceDetailResult;

import java.util.ArrayList;
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

    public void addInsuranceTypeResultList(List<InsuranceTypeResult> insuranceTypeResultList) {
        if(this.insuranceTypeResultList == null) {
            this.insuranceTypeResultList = new ArrayList<>();
            this.insuranceTypeResultList.addAll(insuranceTypeResultList);
        } else {
            this.insuranceTypeResultList.addAll(insuranceTypeResultList);
        }
    }

    public void addInsuranceDetailResultList(List<InsuranceDetailResult> insuranceDetailResultList) {
        if(this.insuranceDetailResultList == null) {
            this.insuranceDetailResultList = new ArrayList<>();
            this.insuranceDetailResultList.addAll(insuranceDetailResultList);
        } else {
            this.insuranceDetailResultList.addAll(insuranceDetailResultList);
        }
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
