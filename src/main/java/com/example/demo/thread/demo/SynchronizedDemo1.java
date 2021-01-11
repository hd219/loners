package com.example.demo.thread.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author : coder
 * @create 2021/1/11 17:02
 */
public class SynchronizedDemo1 {

    synchronized void m(){
        System.out.println("m start " + new Date());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    static class Children extends SynchronizedDemo1{
        @Override
        synchronized void m(){
            System.out.println("child m start");
            super.m();
            System.out.println("child m end");
        }

    }

    public static void main(String[] args) {
        new Children().m();
    }

}
