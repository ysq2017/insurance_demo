package com.neo.drools.model.fact;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Result {

    private List<com.neo.drools.model.fact.InsuranceResult> results;

    public List<com.neo.drools.model.fact.InsuranceResult> getResults() {
        return results;
    }

    public void setResults(List<com.neo.drools.model.fact.InsuranceResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("\"results\":")
                .append(JSONObject.toJSONString(results));
        sb.append('}');
        return sb.toString();
    }
}
