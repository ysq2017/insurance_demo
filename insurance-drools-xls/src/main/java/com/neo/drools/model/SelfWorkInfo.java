package com.neo.drools.model;

/**
 * 本人工作信息
 */
public class SelfWorkInfo {

    INDUSTRY industry;

    public INDUSTRY getIndustry() {
        return industry;
    }

    public void setIndustry(INDUSTRY industry) {
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

    public enum INDUSTRY {
        INDOOR,
        OUTDOOR,
        FREEDOM
    }
}
