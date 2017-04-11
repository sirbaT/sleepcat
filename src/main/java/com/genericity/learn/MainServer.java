package com.genericity.learn;

/**
 * Created by yaguang.wang
 * on 2017/4/11.
 */
public class MainServer {
    public static DepotObject depotObject = new DepotObject("wyg", "String");

    public static void main(String[] args) {
        ObjectDepotAbled abled = (ObjectDepotAbled) depotObject.get();
        if (abled == null) {
            System.out.println("is null");
        } else {
            System.out.println("is not null");
            abled.getClassType();
        }
    }
}
