package com.neo.drools.model;

/**
 * 本人健康信息
 */
public class SelfHealthInfo {

    private Health health;

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SelfHealthInfo{");
        sb.append("\"health\":")
                .append(health);
        sb.append('}');
        return sb.toString();
    }

    public enum Health {
        YES,
        NO
    }
}
