package com.neo.drools.model;

import java.util.List;

/**
 * @author: yangshaoqiang
 * @date: 2018/10/11 15:31
 *
 * 家庭成员
 */
public class FamilyMemberInfo {

    List<FamilyMember> memberList;

    public List<FamilyMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<FamilyMember> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FamilyMemberInfo{");
        sb.append("\"memberList\":")
                .append(memberList);
        sb.append('}');
        return sb.toString();
    }
}
