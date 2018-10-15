package com.neo.drools.point;

import com.neo.drools.model.fact.InsuranceResult;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;
import java.util.List;

public class clacPointXls {

    static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("ksession-calcXLS");
    }

    public static void main(String[] args) {
//        KieSession kSession = getSession();
//
//        User user = new User();
//        user.setName("张学友");
//        user.setLevel(1);
//        Order order1 = new Order(new Date(),90,user,0);
//        Order order2 = new Order(new Date(),400,user,0);
//        Order order3 = new Order(new Date(),500,user,0);
//        Order order4 = new Order(new Date(),6000,user,0);
//        Order order5 = new Order(new Date(),600,user,20000);
//
//        List<Order> orderList = new ArrayList();
//        orderList.add(order1);
//        orderList.add(order2);
//        orderList.add(order3);
//        orderList.add(order4);
//        orderList.add(order5);
//
//        for(Order order:orderList){
//            kSession.insert(order);
//        }
//
//        int ruleFiredCount = kSession.fireAllRules();
//        kSession.dispose();
//
//        System.out.println("触发了" + ruleFiredCount + "条规则");
//
//
//        for(Order order:orderList){
//            System.out.println("amount:"+order.getAmount() +", score:"+ order.getScore());
//        }
//
//
//

    }


    static List<InsuranceResult> addResult(InsuranceResult.InsuranceEnum insuranceEnum, int score){
        InsuranceResult result = new InsuranceResult(score, insuranceEnum);
        return Arrays.asList(result);
    }



}
