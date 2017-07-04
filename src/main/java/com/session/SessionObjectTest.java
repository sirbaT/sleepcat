package com.session;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaguang.wang
 * on 2017/7/4.
 */
public class SessionObjectTest<T> {
    private Map<String, T> sessionObject;

    SessionObjectTest() {
        sessionObject = new HashMap<>();
    }

    public static void main(String[] args) {
        SessionObjectTest<TestBean> test = new SessionObjectTest<>();
        TestBean bean = new TestBean();
        bean.setId("1");
        TestBean one = test.getT(TestBean::new);
        System.out.println(one.getId());
        test.set(bean);
        TestBean second = test.getT(TestBean::new);
        System.out.println(second.getId());
        test.cleanT(TestBean::new);
        System.out.println(test.getT(TestBean::new).getId());
    }

    private T createT(TFunction<T> t) {
        return t.doWork();
    }

    public void set(T obj) {
        sessionObject.put("key", obj);
    }

    public T getT(TFunction<T> t) {
        Object obj = sessionObject.get("key");
        if (obj == null) {
            return createT(t);
        }
        return (T) obj;
    }

    public void cleanT(TFunction<T> t) {
        sessionObject.put("key", t.doWork());
    }
}
