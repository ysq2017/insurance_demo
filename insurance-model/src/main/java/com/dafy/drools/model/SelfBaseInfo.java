package com.dafy.drools.model;

import com.dafy.drools.constants.SexEnum;

/**
 * 本人基础信息
 */
public class SelfBaseInfo {

    private SexEnum sex;

    private Integer age;

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SelfBaseInfo{");
        sb.append("\"sex\":")
                .append(sex);
        sb.append(",\"age\":")
                .append(age);
        sb.append('}');
        return sb.toString();
    }

}
