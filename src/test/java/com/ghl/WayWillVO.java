package com.ghl;

import java.util.ArrayList;
import java.util.List;

public class WayWillVO {

    private List<String> s1;
    private List<String> s2;

    public WayWillVO() {
        s1 = new ArrayList<>();
        s2 = new ArrayList<>();
    }

    public List<String> getS1() {
        return s1;
    }

    public void setS1(List<String> s1) {
        this.s1.addAll(s1);
    }

    public List<String> getS2() {
        return s2;
    }

    public void setS2(List<String> s2) {
        this.s2.addAll(s2);
    }

    @Override
    public String toString() {
        return "WayWillVO{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }
}
