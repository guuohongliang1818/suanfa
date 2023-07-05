package com.ghl;

import com.ghl.datastructure.SingleLinkedList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicReference;

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
    }

}
