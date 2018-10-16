package com.neo.drools.service;

import com.neo.drools.dto.request.RequestParams;

/**
 * 前端交互层，组装输入和输出
 * @author yangshaoqiang
 * @date 2018/10/16 14:44
 */
public interface InsuranceService {

    String getInsuranceResult(RequestParams requestParams);

}
