package com.subject;

/**
 * Created by 主题 on 2017/2/9.
 */
public interface Subject {
    void registerObserver();

    void removeObserver();

    void notifObserver();
}
