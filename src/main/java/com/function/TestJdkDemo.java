package com.function;

/**
 * Created by yaguang.wang
 * on 2017/7/3.
 */
public class TestJdkDemo {
    public static void main(String[] args) {
        doSomething(() -> System.out.println("test jdk demo!"));
    }

    private static void doSomething(MySimplyFunctionInterface msfi) {
        msfi.doWork();
    }
}
