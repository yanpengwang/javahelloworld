package com.wyp.testVirtualFunction;

public class Test {
    public static void main(String[] args) {
        //P b = new B();
        //System.out.println("ok");
        //Integer i = 5;
        //assert i > 9 : "assert output";
        //Person p = new Person();
        //p.print(1);
        //p.print(2);
        String fileType = "null";
        String formatKey = new StringBuilder().append("/").append(fileType).toString();
        System.out.println(formatKey);
    }

    static class P {
        public int a = 11;

        public P() {
            a = 22;
            display();
        }

        public void display() {
            System.out.println("I am in P, value is " + a);
        }
    }

    static class B extends P {
        int a = 33;

        public B() {
            a = 44;
            display();
        }

        public void display() {
            System.out.println("I am in B, value is " + a);
        }
    }
}