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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
    public void test4() {
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
    public void test5() {
        String fileName = "E:/报表.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student("1", "张三", "2000-01-01");
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
    public void test6() {
        Integer i1 = 129;
        int i2 = 129;
        System.out.println(i1.equals(i2));
    }


    @Test
    public void test8() {
        double lon1 = 116.3225715637207;
        double lat1 = 39.909209536859834;
        double lon2 = 116.415596;
        double lat2 = 39.901045;

        GlobalCoordinates source = new GlobalCoordinates(lat1,lon1);
        GlobalCoordinates target = new GlobalCoordinates(lat2,lon2);

        double meter1 = GetDistanceMeter.getDistanceMeter(source, target, Ellipsoid.Sphere);
        double meter2 = GetDistanceMeter.getDistanceMeter(source, target, Ellipsoid.WGS84);

        System.out.println("Sphere坐标系计算结果：" + meter1 + "米");
        System.out.println("WGS84坐标系计算结果：" + meter2 + "米");

    }


    @Test
    public void test9() {
        LocalDateTime now = LocalDateTime.now();
        //LocalDateTime now = LocalDateTime.of(2023, 07, 18, 9, 53, 58);
        System.out.println("当前时间：" + now);
        LocalDateTime minusTime_5 = now.minusMinutes(5);
        System.out.println("当前时间减少5分钟：" + minusTime_5);
        System.out.println("beginofday"+minusTime_5.with(LocalTime.MIN));
        System.out.println("endofday"+minusTime_5.with(LocalTime.MAX));
        LocalDateTime minusTime_6 = now.minusMinutes(5 + 1);
        System.out.println("当前时间减少6分钟：" + minusTime_6);
        //格式化当前时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String to = dtf.format(now.minusMinutes(5));
        System.out.println("minusTime_5：" + to);
        String from = dtf.format(now.minusMinutes(5 + 1));
        System.out.println("minusTime_6：" + from);
        //当前时间-数据库>=5,才执行后续的更新逻辑
        //即 当前时间-5>=数据库时间
    }

    @Test
    public void test10() {
        Vector2D point1 = new Vector2D(39.901045, 116.415596);//out
        Vector2D cPoint = new Vector2D(39.909209536859834, 116.3225715637207);
        PointAndSurface.isPointInCircle(cPoint, 8000, point1);
    }

    @Test
    public void test11() {
        List<String> locations = new ArrayList<String>();
        double lat = 41.993035;
        double lon = 102.092473;
        locations.add(new BigDecimal(lon).divide(new BigDecimal(600000), 6, RoundingMode.HALF_UP).setScale(6, RoundingMode.UNNECESSARY) + "," + new BigDecimal(lat).divide(new BigDecimal(600000), 6, RoundingMode.HALF_UP).setScale(6, RoundingMode.UNNECESSARY));
        System.out.println(locations);
        String locationStr = locations.stream().map(String::valueOf).collect(Collectors.joining("|"));
        System.out.println(locationStr);
    }
    @Test
    public void test12() {
        Map<String,Object> map = new HashMap<>();
        map.put("ss","ss");
        String ss = (String)map.get("zz");
//        System.out.println(ss);
        String s = "你好";
        System.out.println(s);
        String s1 =  null;
//        String.valueOf()
        System.out.println(s1);
        StringBuilder sb_end = new StringBuilder();
        sb_end.append("你好"+"tshia")
                .append(s1);
        System.out.println(sb_end.toString());
    }

    @Test
    public void test13(){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务开始");
                    Thread.sleep(3000);
                    System.out.println("任务结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3, 5, TimeUnit.SECONDS);//首次延迟1秒，之后每30秒执行一次
    }

}
