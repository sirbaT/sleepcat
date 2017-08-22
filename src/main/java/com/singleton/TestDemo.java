package com.singleton;

/**
 * Created by 37497 on 2017/7/30.
 */
public class TestDemo implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new TestDemo());
        Thread thread1 = new Thread(new BDemo());
        thread.start();
        thread1.start();
    }

    @Override
    public void run() {
        Singleton singleton = Singleton.getSingleton();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
