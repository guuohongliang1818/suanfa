package com.ghl;

import com.ghl.datastructure.SingleLinkedList;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class Test01 {

    @Test
    public void test1() {
        BigDecimal a = new BigDecimal(15);
        BigDecimal b = new BigDecimal(-2);
        BigDecimal c = new BigDecimal(3);
        b = b.multiply(c);
        System.out.println("b:" + b);
        a = a.add(b);
        System.out.println("a:" + a);
    }

    @Test
    public void test2() {

        System.out.println("a:" + (10+(-2)*3));
        System.out.println("a:" + (10+(2)*3));
    }

}
