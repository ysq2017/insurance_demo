package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 * 收入阶层
 */
public enum LabelIncomeEnum {
    SALARIAT((byte)0, "工薪阶层"),
    WELL_TO_DO((byte)1, "小康之家"),
    MIDDLE_CLASS((byte)2, "中产阶级"),
    RICH((byte)3, "土豪");
    byte value;
    String desc;

    LabelIncomeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static LabelIncomeEnum getByValue(Byte value) {
        for (LabelIncomeEnum incomeEnum : LabelIncomeEnum.values()) {
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
