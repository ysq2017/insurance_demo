package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 * 收入类别
 */
public enum LabelIncomeTypeEnum {
    INVEST((byte)0, "投资达人");
    byte value;
    String desc;

    LabelIncomeTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static LabelIncomeTypeEnum getByValue(Byte value) {
        for (LabelIncomeTypeEnum incomeEnum : LabelIncomeTypeEnum.values()) {
            if (incomeEnum.value == value) {
                return incomeEnum;
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
