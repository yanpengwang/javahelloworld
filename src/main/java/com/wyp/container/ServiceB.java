package com.wyp.container;

@SimpleSingleton
public class ServiceB {
    public void action() {
        System.out.println("I'm B" + i++);
    }
    private Integer i = 0;
}
