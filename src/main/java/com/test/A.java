package com.test;

/**
 * Created by yaguang.wang
 * on 2017/11/2.
 */
public class A extends B {
    static int i = 1;

    static {
        System.out.println("Class A1:static blocks" + i);
    }

    static {
        i++;
        System.out.println("Class A2:static blocks" + i);
    }

    int j = 1;

    {
        i++;
        j++;
        System.out.println("Class A2:common blocks" + "i=" + i + ",j=" + j);
    }

    public A() {
        super();
        i++;
        j++;
        System.out.println("constructor A:" + "i=" + i + ",j=" + j);
    }

    public static void aTest() {
        i++;
        System.out.println("Class A:static void aTest():" + "i=" + i);
    }

    public void aDisplay() {
        i++;
        System.out.println("Class A:void aDisplay():" + "i=" + i + ",j=" + j);
    }
}
