package com.wyp.basics;


import java.io.IOException;

public class SequenceNumber {

    //private  int seqNum = 0;

    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(()-> 0);

    public int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }


    public static void main(String[] args) throws InterruptedException{
        SequenceNumber sn = new SequenceNumber();
        TestClient t1  = new TestClient(sn, "t1");
        TestClient t2  = new TestClient(sn, "t2");
        TestClient t3  = new TestClient(sn, "t3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(100);

        t1.print();
        t2.print();
        t3.print();


    }

    private static class TestClient extends Thread{
        private SequenceNumber sn ;
        private String clientName;
        public TestClient(SequenceNumber sn , String name){
            super.setName(name);
            this.sn = sn;
            this.clientName = name;

        }

        @Override
        public void run(){
            for(int i=0; i< 3; i++){
                System.out.println( Thread.currentThread().getName()  + ": " + clientName + " , -run-> " + sn.getNextNum());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        public void  print() {
            for(int i=0; i< 3; i++){
                System.out.println( Thread.currentThread().getName()  + ": " + clientName + " , +print+> " + sn.getNextNum());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
