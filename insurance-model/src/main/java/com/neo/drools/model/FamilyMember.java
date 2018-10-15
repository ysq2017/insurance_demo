package com.neo.drools.model;

/**
 * @author: yangshaoqiang
 * @date: 2018/10/11 15:42
 */
public class FamilyMember {

    private Role role;

    Integer age;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public enum Role {
        PARENT,
        SPOUSE,
        CHILD
    }
}
