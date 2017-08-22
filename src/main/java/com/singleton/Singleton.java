package com.singleton;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 37497 on 2017/7/30.
 */
@Setter
@Getter
public class Singleton {
    //    private final static Singleton t1 = new Singleton();
    private static Singleton t1;
    private final String str;

    private Singleton() {
        str = "2";
    }

    public static Singleton getSingleton() {
        if (t1 == null) {
            synchronized (new Object()) {
                if (t1 == null) {
                    t1 = new Singleton();
                }
            }
        }
        return t1;
    }
}
