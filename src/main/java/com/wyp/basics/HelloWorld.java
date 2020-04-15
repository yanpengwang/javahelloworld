package com.wyp.basics;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HelloWorld {

    public void myLog(String input){
        log.info(input);
    }
    public static void main(String[] args){
        String outS = null;
        //System.out.println(outS);
        log.info(outS);
    }
}
