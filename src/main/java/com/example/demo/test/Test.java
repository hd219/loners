package com.example.demo.test;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openjdk.jol.info.ClassLayout;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : coder
 * @create 2020/11/29 14:09
 */
public class Test {

    public static final ThreadFactory factory = new ThreadFactoryBuilder().setNamePrefix("demo-pool").build();
    public static final ExecutorService executorService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(1024), factory,
            new ThreadPoolExecutor.AbortPolicy());

    volatile boolean running = true;

    void m() {
        System.out.println(" m  start");
        while (running) {

        }
        System.out.println(" m end");
    }

    List<Integer> getList() {
        System.out.println("list");
        return Lists.newArrayList();
    }

    List<Integer> getList(int type, double f) {
        System.out.println("list");
        return Lists.newArrayList();
    }

    void getList(int type) {
        System.out.println("void");
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class DataTest implements Serializable {
        String id;
        int type;
        int client;
        int status;
    }

    static int getCount(int receiveCount) {
        int number = receiveCount < 100 ? (100 - receiveCount) % 100 : 100 - (receiveCount % 100);
        if (number == 0) {
            number = 100;
        }
        return number;
    }

    public static void main(String[] args) {
//        Test t = new Test();
//        executorService.submit(t::m);
////        new Thread(t::m, "t1").start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t.running = false;
//        String id = "kkkk";
//        String s = "{\"client\":" + 1 + ",\"id\":" + "test" + ",\"status\":" + 1 + ",\"type\":" + 1 + "}";
//        System.out.println(JSON.toJSONString(new DataTest("ssss", 1, 1, 1)));
//        System.out.println(s);
//        String s1 = ClassLayout.parseInstance(new Object()).toPrintable();
//        System.out.println(s1);
//        System.out.println((100 - 20) % 100);
//        System.out.println((320 - 20) % 100);
//        System.out.println(321 % 100);
        int count = getCount(400);
        System.out.println(count);

        System.out.println(new Date(0));

    }

}
