package com.dafy.drools.service;

import com.dafy.drools.model.request.ReportRequest;
import com.dafy.drools.model.request.SelfInsuranceRequest;
import com.dafy.drools.model.response.InsuranceRecommendResponse;
import com.dafy.drools.model.response.ReportResponse;

/**
 * 推荐Inner服务，决策表交互层
 * @author yangshaoqiang
 * @date 2018/10/15 20:12
 */
public interface RecommendInnerService {

    String test(int income, int health, int industry);

    /**
     * 本人保险推荐
     * @param request
     * @return
     */
    InsuranceRecommendResponse selfRecommend(SelfInsuranceRequest request);

    /**
     * 其他家庭成员保险推荐
     */


    /**
     * 生成报告
     */
    ReportResponse getReport(ReportRequest request);

}
