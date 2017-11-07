package com.test;

/**
 * Created by yaguang.wang
 * on 2017/11/2.
 */
public class B {
    // 静态变量
    static int i = 1;

    // 静态语句块
    static {
        System.out.println("Class B1:static blocks" + i);
    }

    // 静态语句块
    static {
        i++;
        System.out.println("Class B2:static blocks" + i);
    }

    // 非静态变量
    int j = 1;

    // 非静态语句块
    {
        i++;
        j++;
        System.out.println("ClassB: common blocks" + "i=" + i + ",j=" + j);
    }

    // 构造函数
    public B() {
        i++;
        j++;
        System.out.println("constructorB:" + "i=" + i + ",j=" + j);
    }

    // 静态方法
    public static void bTest() {
        i++;
        System.out.println("Class B:static void bTest():" + "i=" + i);
    }

    // 非静态方法
    public void bDisplay() {
        i++;
        System.out.println("Class B:void bDisplay():" + "i=" + i + ",j=" + j);
    }
}
