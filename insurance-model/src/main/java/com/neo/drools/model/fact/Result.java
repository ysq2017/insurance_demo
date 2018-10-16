package com.neo.drools.model.fact;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Result {

    private List<InsuranceTypeResult> results;

    public List<InsuranceTypeResult> getResults() {
        return results;
    }

    public void setResults(List<InsuranceTypeResult> results) {
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
