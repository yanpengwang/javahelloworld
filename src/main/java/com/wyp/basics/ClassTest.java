package com.wyp.basics;

import java.lang.reflect.Field;
import java.net.URL;

public class ClassTest {

    private static Class<One> one = One.class;

    public static void main(String[] args) throws Exception{

        One oneObject = one.newInstance();
        oneObject.call();

        Field privateFieldInOne = one.getDeclaredField("inner");
        privateFieldInOne.setAccessible(true);
        privateFieldInOne.set(oneObject, "changed.");
        System.out.println(oneObject.getInner());

        ClassLoader c = one.getClassLoader().getParent().getParent();
        System.out.println(c);

        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        for (java.net.URL url: urLs) {
            System.out.println(url.toExternalForm());
        }
    }
}

class One {
    private String inner = "time flies.";
    public void call() {
        System.out.println("Hello world");
    }
    public String getInner(){
        return inner;
    }
}

class Another {
    public void speak() {
        System.out.println("easy coding.");
    }
}
