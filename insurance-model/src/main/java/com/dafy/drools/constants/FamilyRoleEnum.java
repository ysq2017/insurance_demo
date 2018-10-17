package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:58
 */
public enum FamilyRoleEnum {
    SELF((byte)0, "本人"),
    SPOUSE((byte)1, "配偶"),
    SELF_FATHER((byte)2, "本人父亲"),
    SELF_MOTHER((byte)3, "本人母亲"),
    SPOUSE_FATHER((byte)4, "配偶父亲"),
    SPOUSE_MOTHER((byte)5, "配偶母亲"),
    CHILD((byte)6, "子女");

    byte value;
    String desc;

    FamilyRoleEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static FamilyRoleEnum getByValue(Byte value) {
        for (FamilyRoleEnum roleEnum : FamilyRoleEnum.values()) {
            if (roleEnum.value == value) {
                return roleEnum;
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
