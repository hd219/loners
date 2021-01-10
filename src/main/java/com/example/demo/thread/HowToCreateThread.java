package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author : coder
 * @create 2021/1/10 18:08
 */
public class HowToCreateThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello my thread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello my run");
        }
    }

    static class MyCall implements Callable<String> {

        int a = 0;

        @Override
        public String call() throws Exception {
            ++a;
            System.out.println(Thread.currentThread().getName() + ",a=" + a);
            return String.valueOf(a);
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> System.out.println("hello lambda")).start();

        //callable
        MyCall myCall = new MyCall();
        FutureTask<String> task = new FutureTask<>(myCall);
        new Thread(task, "thread1").start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
