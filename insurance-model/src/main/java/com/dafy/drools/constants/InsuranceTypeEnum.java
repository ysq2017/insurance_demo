package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 */
// 保险大类
public enum InsuranceTypeEnum {
    MEDICAL((byte)1, 30, 300, "医疗"),
    SERIOUS_ILLNESS((byte)2, 50, 500, "重疾"),
    SAVING((byte)3, 10, 100, "储蓄"),
    ACCIDENT((byte)4, 20, 200, "意外");

    private Byte type;

    /**
     * 最低额度
     */
    private Integer min;

    /**
     * 最高额度
     */
    private Integer max;

    private String desc;

    InsuranceTypeEnum(Byte type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     *
     * @param type
     * @param min 最小范围：万元
     * @param max 最大范围：万元
     * @param desc
     */
    InsuranceTypeEnum(Byte type, Integer min, Integer max, String desc) {
        this.type = type;
        this.min = min;
        this.max = max;
        this.desc = desc;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static InsuranceTypeEnum getByType(Byte type) {
        for (InsuranceTypeEnum insuranceTypeEnum : InsuranceTypeEnum.values()) {
            if (insuranceTypeEnum.type.equals(type)) {
                return insuranceTypeEnum;
            }
        }
        return null;
    }


    /**
     * 保险细分类型
     */
    public enum InsuranceDetailEnum{

        MEDICAL_1(101, MEDICAL.getType(), 30, 300, "医疗险一号"),

        MEDICAL_2(102, MEDICAL.getType(), 30, 300, "医疗险二号"),

        SERIOUS_ILLNESS_1(201, SERIOUS_ILLNESS.getType(), 50, 500, "重疾险一号"),

        SERIOUS_ILLNESS_2(202, SERIOUS_ILLNESS.getType(), 50, 400, "重疾险二号"),

        SERIOUS_ILLNESS_3(203, SERIOUS_ILLNESS.getType(), 50, 300, "重疾险三号"),

        SAVING_1(301, SAVING.getType(), 10, 100, "储蓄险一号"),

        ACCIDENT_1(401, ACCIDENT.getType(), 20, 200, "意外险一号");

        private Integer type;

        private Byte parentType;

        private Integer min;

        private Integer max;

        private String description;

        /**
         *
         * @param type
         * @param parentType 父类别
         * @param min 最小范围：万元
         * @param max 最大范围：万元
         * @param description
         */
        InsuranceDetailEnum(Integer type, Byte parentType, Integer min, Integer max, String description) {
            this.type = type;
            this.parentType = parentType;
            this.min = min;
            this.max = max;
            this.description = description;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Byte getParentType() {
            return parentType;
        }

        public void setParentType(Byte parentType) {
            this.parentType = parentType;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public static InsuranceDetailEnum getByType(Integer type) {
            for (InsuranceDetailEnum insuranceDetailEnum : InsuranceDetailEnum.values()) {
                if (insuranceDetailEnum.type.equals(type)) {
                    return insuranceDetailEnum;
                }
            }
            return null;
        }
    }

}
