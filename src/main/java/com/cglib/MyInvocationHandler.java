package com.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yaguang.wang
 * on 2017/8/22.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    MyInvocationHandler() {
        super();
    }

    MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before---------------");
        Object result = method.invoke(target, args);
        System.out.println("after-----------------");
        return null;
    }
}
