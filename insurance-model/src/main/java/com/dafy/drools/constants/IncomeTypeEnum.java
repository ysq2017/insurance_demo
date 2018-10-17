package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 * 收入类别
 */
public enum IncomeTypeEnum {
    WAGE((byte)0, "工资"),
    INVEST((byte)1, "投资收入"),
    UNKNOWN((byte)2, "未知");
    byte value;
    String desc;

    IncomeTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static IncomeTypeEnum getByValue(Byte value) {
        for (IncomeTypeEnum incomeTypeEnum : IncomeTypeEnum.values()) {
            if (incomeTypeEnum.value == value) {
                return incomeTypeEnum;
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
