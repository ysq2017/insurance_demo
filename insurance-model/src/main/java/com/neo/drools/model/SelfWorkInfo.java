package com.neo.drools.model;

/**
 * 本人工作信息
 */
public class SelfWorkInfo {

    IndustryEnum industry;

    public IndustryEnum getIndustry() {
        return industry;
    }

    public void setIndustry(IndustryEnum industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SelfWorkInfo{");
        sb.append("\"industry\":")
                .append(industry);
        sb.append('}');
        return sb.toString();
    }

    public enum IndustryEnum {
        INDOOR(1, "室内"),
        OUTDOOR(2, "室外"),
        FREEDOM(3, "自由");

        private int id;

        private String desc;

        private IndustryEnum(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public static IndustryEnum getByValue(int value) {
            for (IndustryEnum industryEnum : IndustryEnum.values()) {
                if (industryEnum.id == value) {
                    return industryEnum;
                }
            }
            return null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("IndustryEnum{");
            sb.append("\"id\":")
                    .append(id);
            sb.append(",\"desc\":\"")
                    .append(desc).append('\"');
            sb.append('}');
            return sb.toString();
        }
    }
}
