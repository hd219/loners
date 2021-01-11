package com.example.demo.thread.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 程序在执行过程中，如果出现异常，默认情况锁会被释放
 * 所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况
 * 比如，在一个web app处理过程中，多个serverlet线程共同访问同一个资源，这是如果处理异常不合适，在第一个线程中抛出异常，其他线程会进入同步代码区，
 * 有可能会访问到异常产生时的数据，因此要非常小心处理同步业务逻辑中 的异常
 *
 * @author : coder
 * @create 2021/1/11 17:12
 */
public class SynchronizedDemo2 {

    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start " + new Date());
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                //此处抛出异常 锁将被自动释放 想要不被释放
                int i = 1 / 0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo2 t = new SynchronizedDemo2();
        Runnable r = t::m;
        new Thread(r, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();
    }

}
