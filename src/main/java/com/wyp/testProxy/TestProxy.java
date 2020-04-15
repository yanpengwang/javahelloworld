package com.wyp.testProxy;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        //加入这一段可以在磁盘中生成 代理类，让我们看到代理类的真面目
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Sourceable source = new Source();
        ClassLoader myLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("myLoader = " + myLoader);
        Sourceable prx = (Sourceable) Proxy.newProxyInstance(
            myLoader, new Class[]{Sourceable.class},
            (proxy, method, args2) -> {
                System.out.println("basics");
                if ("methodName".equals(method.getName())) {
                    return method.invoke(source, args2);
                }
                return null;
            }
        );
        System.out.println(prx.methodName("haha"));
    }
}
