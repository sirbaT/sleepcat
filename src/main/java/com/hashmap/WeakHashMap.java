package com.hashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by yaguang.wang
 * on 2017/3/31.
 */
public class WeakHashMap implements Map {
    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public Object get(Object key) {
        return null;
    }

    public Object put(Object key, Object value) {
        return null;
    }

    public Object remove(Object key) {
        return null;
    }

    public void putAll(Map m) {

    }

    public void clear() {

    }

    public Set keySet() {
        return null;
    }

    public Collection values() {
        return null;
    }

    public Set<Entry> entrySet() {
        return null;
    }

    public boolean equals(Object o) {
        return o == this;
    }

    public int hashCode() {
        return 0;
    }
}
