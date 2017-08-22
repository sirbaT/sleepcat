package com.singleton;

/**
 * Created by 37497 on 2017/7/30.
 */
public class BDemo implements Runnable{

    @Override
    public void run() {
        Singleton singleton = Singleton.getSingleton();
        try {
            Object.class.wait();
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(singleton.getStr());
    }
}
