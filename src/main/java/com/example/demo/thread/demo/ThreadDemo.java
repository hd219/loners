package com.example.demo.thread.demo;

/**
 * @author : coder
 * @create 2021/1/11 14:30
 */
public class ThreadDemo implements Runnable {

    private int count = 100;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }

}
