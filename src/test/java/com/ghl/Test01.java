package com.ghl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.ghl.datastructure.SingleLinkedList;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void test5(){
        String fileName="E:/报表.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
        List<Student> studentList=new ArrayList<Student>();
        Student student=new Student("1","张三","2000-01-01");
        studentList.add(student);
        //这里 需要指定写用哪个class去写
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "学生信息1").head(Student.class).build();
        excelWriter.write(studentList, writeSheet);
        writeSheet = EasyExcel.writerSheet(1, "学生信息2").head(Student.class).build();
        excelWriter.write(studentList, writeSheet);
        //千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    @Test
    public void test6(){
       Integer i1 = 129;
       int i2 = 129;
       System.out.println(i1.equals(i2));
    }


    @Test
    public void test8(){
        double lon1 = 95.660281;
        double lat1 = 42.286693;
        double lon2 = 95.687353;
        double lat2 = 42.513003;

        GlobalCoordinates source = new GlobalCoordinates(lon1, lat1);
        GlobalCoordinates target = new GlobalCoordinates(lon2, lat2);

        double meter1 = GetDistanceMeter.getDistanceMeter(source, target, Ellipsoid.Sphere);
        double meter2 = GetDistanceMeter.getDistanceMeter(source, target, Ellipsoid.WGS84);

        System.out.println("Sphere坐标系计算结果："+meter1 + "米");
        System.out.println("WGS84坐标系计算结果："+meter2 + "米");

    }

}
