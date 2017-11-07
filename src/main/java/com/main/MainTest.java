package com.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaguang.wang
 * on 2017/7/4.
 */
public interface MainTest {
    static void main(String[] args) {
        List<Long> a = new ArrayList<>();
        a.stream();
        System.out.println(a);
        System.out.println("Hello world!");
    }
}
