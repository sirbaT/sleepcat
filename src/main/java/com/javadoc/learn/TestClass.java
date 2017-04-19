package com.javadoc.learn;

import com.hashmap.WeakHashMap;

/**
 * @author yaguang.wang1
 *         <pre>
 *                         Created by yaguang.wang
 *                         @author yaguang.wang2
 *                         on 2017/4/19.
 *                         </pre>
 *         <ol>
 *         <li>first</li>
 *         <li>search</li>
 *         <li>third</li>
 *         </ol>
 * @see com.javadoc.learn.TestClass
 */
public class TestClass {
    /**
     * This is a public filed
     *
     * @version 20170419
     * @author yaguang.wang
     */
    public Integer oneFiled;

    /**
     * @version 20170419
     * @author yaguang.wang
     * @see com.hashmap.WeakHashMap
     */
    @Deprecated
    public void oneMethod(WeakHashMap map) {
        return;
    }
}
