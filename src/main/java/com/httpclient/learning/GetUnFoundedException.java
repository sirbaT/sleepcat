package com.httpclient.learning;

/**
 * Get founded failed
 * Created by yaguang.wang on 2016/11/18.
 */
public class GetUnFoundedException extends RuntimeException {
    GetUnFoundedException(String message) {
        super(message);
    }
}
