package com.ghl;

import com.ghl.datastructure.SingleLinkedList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Test01 {

    @Test
    public void test1() {
        BigDecimal a = new BigDecimal(678).divide(new BigDecimal(1000)).setScale(2, RoundingMode.UP);

        BigDecimal b = new BigDecimal(-2);
        BigDecimal c = new BigDecimal(3);
//        b = b.multiply(c);
        System.out.println("a:" + a);
//        a = a.add(b);
//        System.out.println("a:" + a);
        AtomicReference<BigDecimal> mileageValue = new AtomicReference<>(new BigDecimal(0));
        for (int i = 0; i < 100; i++) {
            mileageValue.set(mileageValue.get().add(new BigDecimal(i)));
        }
        System.out.println(mileageValue);
        if (a.compareTo(BigDecimal.ZERO) != 0) {
            System.out.println("a:不等于0");
        } else {
            System.out.println("a:等于0");
        }
    }

    @Test
    public void test2() {

        System.out.println("a:" + (10 + (-2) * 3));
        System.out.println("a:" + (10 + (2) * 3));
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
//        list.add("111");
//        list.add("222");
//        list.add("333");
//        list.add("444");

        System.out.println(list.stream().filter(e -> !"111".equals(e)).collect(Collectors.toList()));
    }

    @Test
    public void test4(){
        WayWillVO WayWillVO = new WayWillVO();
        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        WayWillVO.setS1(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("2");
        l2.add("3");
        WayWillVO.setS2(l2);
        System.out.println(WayWillVO.getS1());

        WayWillVO.getS1().addAll(WayWillVO.getS2());

        System.out.println(WayWillVO.getS1());

    }

}
