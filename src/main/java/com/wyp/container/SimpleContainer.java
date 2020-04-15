package com.wyp.container;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleContainer {
    public static <T> T getInstance(Class<T> cls) {
        try {
            boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if(!singleton){
                return createInstance(cls);
            }
            Object obj = instances.get(cls);
            if(obj != null){
                return (T) obj;
            }
            synchronized (cls){
                obj = instances.get(cls);
                if(obj == null) {
                    obj = createInstance(cls);
                    instances.put(cls, obj);
                }
            }
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T createInstance(Class<T> cls) throws Exception{

        T obj = cls.newInstance();
        Field[] fields = cls.getDeclaredFields();
        for(Field f : fields){
            if(f.isAnnotationPresent(SimpleInject.class)){
                if(!f.isAccessible()){
                    f.setAccessible(true);
                }
                Class<?> filedCls = f.getType();
                f.set(obj, getInstance(filedCls));
            }
        }
        return obj;

    }

    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();
}
