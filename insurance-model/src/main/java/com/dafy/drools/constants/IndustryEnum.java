package com.dafy.drools.constants;

/**
 * @author yangshaoqiang
 * @date 2018/10/16 11:57
 */
public enum IndustryEnum {
    INDOOR(1, "室内"),
    OUTDOOR(2, "室外"),
    FREEDOM(3, "自由职业"),
    INTERNET(4, "互联网"),
    EDUCATION(5, "教育业"),
    FINANCE(6, "金融业");

    private int id;

    private String desc;

    IndustryEnum(int id, String desc) {
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
