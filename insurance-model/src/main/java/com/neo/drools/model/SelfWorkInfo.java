package com.neo.drools.model;

import com.neo.drools.constants.IndustryEnum;

/**
 * 本人工作信息
 */
public class SelfWorkInfo {

    private IndustryEnum industry;

    public IndustryEnum getIndustry() {
        return industry;
    }

    public void setIndustry(IndustryEnum industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SelfWorkInfo{");
        sb.append("\"industry\":")
                .append(industry);
        sb.append('}');
        return sb.toString();
    }

}
