package com.spider.sleepcat.accumulator;

/**
 * Created by yaguang.wang
 * on 2017/3/23.
 * 可收集的用户收集某些东西
 * 这个结构很有趣 基本是把 A 变成 B 的某种 接口 都可以这样写
 */
public interface AccumulatorAble<T, F> {
    T captureSomethingFormSomeWhere(F from);
}
