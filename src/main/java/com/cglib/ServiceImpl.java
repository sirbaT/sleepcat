package com.cglib;

/**
 * Created by yaguang.wang
 * on 2017/8/22.
 */
public class ServiceImpl implements Service {
    @Override
    public void add() {
        System.out.println("serviceImpl add >>>>>>>>>>>>>>>");
    }

    @Override
    public void update() {
        System.out.println("service Impl update >>>>>>>>>>>>>>");
    }
}
