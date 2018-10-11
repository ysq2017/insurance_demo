package com.neo.drools.model.fact;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.List;

public class Result {

    private List<InsuranceResult> results;

    public List<InsuranceResult> getResults() {
        return results;
    }

    public void setResults(List<InsuranceResult> results) {
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
