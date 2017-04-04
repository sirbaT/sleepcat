package com.xiaoyadecaihong.sleepcat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yaguang.wang
 * on 2017/3/18.
 */
public class TestStreamApi {
    @Test
    public void testStreamApi() {
        List<Long> a = new ArrayList<>();
        a.stream().findFirst();

    }
}
