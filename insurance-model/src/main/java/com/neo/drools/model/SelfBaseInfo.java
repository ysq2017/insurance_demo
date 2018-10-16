package com.neo.drools.model;

/**
 * 本人基础信息
 */
public class SelfBaseInfo {

    Byte sex;

    Integer age;

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
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

    public enum SexEnum {
        WOMAN((byte)0, "女"),
        MAN((byte)1, "男"),
        UNKNOWN((byte)2, "未知");
        byte value;
        String desc;

        SexEnum(byte value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public byte getValue() {
            return value;
        }

        public void setValue(byte value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
