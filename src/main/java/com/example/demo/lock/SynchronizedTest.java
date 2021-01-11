package com.example.demo.lock;

/**
 * @author : coder
 * @create 2021/1/10 19:50
 */
public class SynchronizedTest {
    private  static int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + ",count =" + count);
        }
    }

    /**
     *   m1 = m2
     */
    public synchronized static void m1() {
        count--;
        System.out.println(Thread.currentThread().getName() + ",count =" + count);
    }

    public static void m2(){
        synchronized (SynchronizedTest.class){
            count--;
        }
    }

    public static void main(String[] args) {
        new SynchronizedTest().m();
    }

}
