package com.thread;

/**
 * Created by 37497 on 2017/10/14.
 */
public class RunTest implements Runnable {
    @Override
    public void run() {
        System.out.println("This is thread run over.");
    }
}
