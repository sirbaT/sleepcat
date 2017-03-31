package com.xiaoyadecaihong.sleepcat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 测试打开本地的浏览器
 * Created by yaguang.wang
 * on 2017/3/29.
 */
public class TestOpenBrowser {

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec(
                    "rundll32 url.dll,FileProtocolHandler "
                            + url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
