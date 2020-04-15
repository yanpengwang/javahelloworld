package com.wyp.testCglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class SimpleCGLibDemo {

    static class RealService {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback((MethodInterceptor)(object, method, args, proxy) -> {
            System.out.println("Entering..." + method.getName());
            Object result = proxy.invokeSuper(object, args);
            System.out.println("Leaving...");
            return result;
        });
        return (T) enhancer.create();
    }

    public  static void main(String[] args) throws Exception {
        //加入这一段可以在磁盘中生成 代理类，让我们看到代理类的真面目
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/var/tmp/tmpclass");
        RealService proxyService = getProxy(RealService.class);
        proxyService.sayHello();

    }
}
