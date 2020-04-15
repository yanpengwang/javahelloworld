package understandjvm.examples.chatper2_4;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.Scanner;


public class JavaMethodAreaOOM {


    public static void main(String[] args) {
        Integer i = 0;
        while(i++ < 3) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, objArgs, proxy)->proxy.invokeSuper(obj, objArgs));
            enhancer.create();

            Scanner scan = new Scanner(System.in);
            String read = scan.nextLine();
        }



    }

    static class OOMObject {

    }
}
