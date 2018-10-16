package com.neo.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 * 支出类别
 */
public enum ExpenseTypeEnum {
    EDUCATION((byte)0, "教育"),
    SUPPORT((byte)1, "赡养费"), //主要指老人
    REPAYMENT((byte)2, "还贷(房贷车贷等)");
    byte value;
    String desc;

    ExpenseTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ExpenseTypeEnum getByValue(Byte value) {
        for (ExpenseTypeEnum expenseTypeEnum : ExpenseTypeEnum.values()) {
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
