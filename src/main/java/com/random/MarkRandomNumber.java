package com.random;

/**
 * Created by yaguang.wang
 * on 2017/11/7.
 */
public class MarkRandomNumber {
    private final static Long M = (1L << 31) - 1;
    private final static Long A = 48271L;
    private final static Long C = 1L;
    private static Long seed = System.nanoTime();

    public static Integer createRandomNumber() {
        seed = (A * seed + C) % M;
        return seed.intValue();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(createRandomNumber());
        }
    }
}
