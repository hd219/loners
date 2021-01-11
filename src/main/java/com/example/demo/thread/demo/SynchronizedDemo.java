package com.example.demo.thread.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法调用另外一个同步方法 一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的
 * @author : coder
 * @create 2021/1/11 16:55
 */
public class SynchronizedDemo {

    synchronized void  m1(){
        System.out.println("m1 start "+ new Date());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end " + new Date());
    }

    synchronized void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 "+ new Date());
    }

    public static void main(String[] args) {
        new SynchronizedDemo().m1();
    }

}
