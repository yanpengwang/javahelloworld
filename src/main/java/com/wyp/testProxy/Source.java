package com.wyp.testProxy;

import java.io.IOException;

public class Source implements Sourceable{
    @Override
    public int methodName (String input) {
        System.out.println("hello proxy! "+ input);
        return 1;
    }
}
