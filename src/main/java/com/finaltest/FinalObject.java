package com.finaltest;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yaguagn.wang
 * on 2017/11/1.
 */
@Getter
@Setter
public final class FinalObject {
    private String name;

    public static void main(String[] args) {
        FinalObject object = new FinalObject();
        object.setName("w_y_g");
        setNameByObj(object);
        System.out.println(object.getName());
    }

    public static void setNameByObj(FinalObject obj){
        obj.setName("bai_jing_jing");
    }
}
