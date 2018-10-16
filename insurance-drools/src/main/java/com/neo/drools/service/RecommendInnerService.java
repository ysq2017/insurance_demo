package com.neo.drools.service;

import com.neo.drools.model.request.SelfInsuranceRequest;
import com.neo.drools.model.response.InsuranceRecommendResponse;

/**
 * 推荐Inner服务，决策表交互层
 * @author yangshaoqiang
 * @date 2018/10/15 20:12
 */
public interface RecommendInnerService {

    String test(int income, int health, int industry);

    /**
     * 本人保险推荐
     * @param selfInsuranceRequest
     * @return
     */
    InsuranceRecommendResponse selfRecommend(SelfInsuranceRequest selfInsuranceRequest);

    /**
     * 其他家庭成员保险推荐
     */


    /**
     * 生成报告
     */

}
