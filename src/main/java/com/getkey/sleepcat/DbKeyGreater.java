package com.getkey.sleepcat;

/**
 * Created by yaguang.wang
 * on 2017/3/23.
 */

public class DbKeyGreater<T> implements DbKeyGreaterAble{
    private T key;
    public  T getKey() {
        return key;
    }
}
