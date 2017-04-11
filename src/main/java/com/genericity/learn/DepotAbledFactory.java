package com.genericity.learn;

import java.util.Objects;

/**
 * Created by yaguang.wang
 * on 2017/4/11.
 */
public class DepotAbledFactory {
    private String key;

    public DepotAbledFactory(String key) {
        this.key = key;
    }

    public DepotAbled getDepotAbledNewObject() {
        if (Objects.equals(key, "String")) {
            return new ObjectDepotAbled();
        }
        return null;
    }

}
