package com.genericity.learn;

/**
 * Created by yaguang.wang
 * on 2017/4/11.
 */
public class DepotObject<T extends DepotAbled> {
    private String userName;
    private String key;
    private DepotAbledFactory depotAbledFactory ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {

        return key;
    }

    public DepotObject(String userName, String key) {
        this.userName = userName;
        this.key = key;
        depotAbledFactory = new DepotAbledFactory(this.key);
    }

    public void save(T obj) {
        System.out.println("T is save " + obj + ",key is " + key + ",userName is " + userName);
    }

    public T get() {
        return (T) depotAbledFactory.getDepotAbledNewObject();
    }
}
