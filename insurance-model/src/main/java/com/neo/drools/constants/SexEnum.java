package com.neo.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 */
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

    public static SexEnum getByValue(Byte value) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.value == value) {
                return sexEnum;
            }
        }
        return null;
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
