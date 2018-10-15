package com.neo.drools.model;

/**
 * 本人基础信息
 */
public class SelfBaseInfo {

    Integer sex;

    Integer age;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public enum CustomerSex {
        MALE,
        FEMALE
    }
}
