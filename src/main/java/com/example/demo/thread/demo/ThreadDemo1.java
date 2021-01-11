package com.example.demo.thread.demo;

/**
 * @author : coder
 * @create 2021/1/11 14:37
 */

import java.util.Date;

/**
 * 同步方法和非同步方法是否可同时调用
 */
public class ThreadDemo1 {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1 start :" + new Date());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end :" + new Date());
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2");
    }

    public static void main(String[] args) {
        ThreadDemo1 t = new ThreadDemo1();
        new Thread(t::m1).start();
        new Thread(t::m2).start();
    }
}
