package com.classloader;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yaguang.wng
 * JDK 的classLoader对象的学习
 * on 2017/8/22.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = classLoader.loadClass("com.main.MainTestImpl");
        System.out.println(aClass.isAnnotation());
        System.out.println(aClass.isInterface());
        Class<?>[] interfaces = aClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
    }
}
