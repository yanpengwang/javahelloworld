package com.wyp.container;

public class ServiceA {
    @SimpleInject
    ServiceB b;
    public void callB() {
        b.action();
    }
}
