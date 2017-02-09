package com.observer;

import com.subject.ConcreteSubject;

/**
 * Created by 观察着 on 2017/2/9.
 */
public abstract class ConcreteObserver implements Observer {
    protected ConcreteSubject concreateSubject;
}
