package com.thread;

/**
 * Created by 37497 on 2017/10/14.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(testRun());
        Thread.sleep(1000L);
        System.out.println("This is  main over.");
    }

    public static String testRun() {
        Thread t = new Thread(new RunTest());
        t.start();
        return "This is function over.";
    }
}
