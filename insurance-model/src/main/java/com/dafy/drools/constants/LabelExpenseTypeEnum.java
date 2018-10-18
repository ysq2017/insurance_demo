package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 * 支出类别
 */
public enum LabelExpenseTypeEnum {
    HOUSE_SLAVES((byte)0, "房奴一族"),
    CAR_SLAVES((byte)0, "车奴一族");
    byte value;
    String desc;

    LabelExpenseTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static LabelExpenseTypeEnum getByValue(Byte value) {
        for (LabelExpenseTypeEnum expenseTypeEnum : LabelExpenseTypeEnum.values()) {
            if (expenseTypeEnum.value == value) {
                return expenseTypeEnum;
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
