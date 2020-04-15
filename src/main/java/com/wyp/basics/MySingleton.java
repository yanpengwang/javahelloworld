package com.wyp.basics;

interface DoWork{
    void doSomething();
}
public enum MySingleton implements DoWork{
    /**
     * singleton
     */
    INSTANCE {
        @Override
        public void doSomething(){
            System.out.println("Complete Singleton.");
        }
    };
    public static MySingleton getInstance(){
        return MySingleton.INSTANCE;
    }
}
