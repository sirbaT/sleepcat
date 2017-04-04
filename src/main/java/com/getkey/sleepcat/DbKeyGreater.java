package com.getkey.sleepcat;

/**
 * 这个模型不行~ 每次都要给key赋值很容易出现错误
 * Created by yaguang.wang
 * on 2017/3/23.
 */
public class DbKeyGreater<T> implements DbKeyGreaterAble{
    private T key;
    public  T getKey() {
        //fix 给key赋值
        if (!isExistKey(key)) {
            return key;
        }
        throw new RuntimeException("can`t get key");
    }

    private boolean isExistKey(T key) {
        return false;
    }

    private void setKey(T key) {
        this.key = key;
    }
}
