package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 * 支出类别
 */
public enum LabelAgeEnum {
    ZERO_AFTER((byte)0, "00后"),
    NINETY_AFTER((byte)1, "90后"),
    EIGHTY_AFTER((byte)2, "80后"),
    SEVENTY_AFTER((byte)3, "70后"),
    SIXTY_AFTER((byte)4, "60后"),
    FIFTY_AFTER((byte)5, "50后"),
    FORTY_AFTER((byte)6, "40后");
    byte value;
    String desc;

    LabelAgeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static LabelAgeEnum getByValue(Byte value) {
        for (LabelAgeEnum ageEnum : LabelAgeEnum.values()) {
            if (ageEnum.value == value) {
                return ageEnum;
            }
        }
        return null;
    }

    public static LabelAgeEnum getByAge(Integer age) {
        // TODO: 2018/10/18

        return EIGHTY_AFTER;
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
