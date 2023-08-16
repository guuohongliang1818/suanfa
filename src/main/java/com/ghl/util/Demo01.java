package com.ghl.util;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo01 {
    public static void method1() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("任务开始时间："+start);
        Map<String, String> data = new HashMap<>(3);
        //第一个任务。返回参数类型可自定义
        CompletableFuture<String> task01 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task01";
        });
        //第二个任务。返回参数类型可自定义
        CompletableFuture<String> task02 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task02";
        });
        // 第三个任务。返回参数类型可自定义
        CompletableFuture<String> task03 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task03";
        });

        String task01Result = task01.get();
        String task02Result = task02.get();
        String task03Result = task03.get();
        data.put("task01", task01Result);
        data.put("task02", task02Result);
        data.put("task03", task03Result);
        long end = System.currentTimeMillis();
        System.out.println("任务结束时间：" + end);
        System.out.println("耗时：" + (end-start)/1000);
    }

    public static void method3(){
        List<String> list = new ArrayList<>();
        list.add("task01");
        list.add("task02");
        list.add("task03");

        //Map<String,CompletableFuture<String>> map = list.stream().collect(Collectors.toMap());








    }

    public static void method2(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(200);
        threadPoolTaskExecutor.setThreadNamePrefix("task-concurrent-work");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskExecutor.initialize();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(6);
        list.add(null);
        list.add(8);
        list.add(3);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(7);
        long start = System.currentTimeMillis();
        /*
        list.forEach(item -> {
            try {
                System.out.println(item);
                Thread.sleep(item*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/
        //long end = System.currentTimeMillis();
        //System.out.println("耗时："+(end-start) / 1000);

        list.forEach(item -> {
            threadPoolTaskExecutor.execute(() -> {
                try {
                    if (item == 7) {
                        System.out.println(Thread.currentThread() + "任务终止");
                        return;
                    }
                    long end = System.currentTimeMillis();
                    System.out.println(item);
                    Thread.sleep(item * 1000);
                    long end2 = System.currentTimeMillis();
                    System.out.println(Thread.currentThread() + "耗时：" + (end2 - end) / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        threadPoolTaskExecutor.shutdown();

        list.forEach(item -> {
            threadPoolTaskExecutor.execute(() -> {
                try {
                    if (item == 7) {
                        System.out.println(Thread.currentThread() + "任务终止");
                        return;
                    }
                    long end = System.currentTimeMillis();
                    System.out.println(item);
                    Thread.sleep(item * 1000);
                    long end2 = System.currentTimeMillis();
                    System.out.println(Thread.currentThread() + "耗时：" + (end2 - end) / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method1();
    }
}
