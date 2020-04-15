package understandjvm.examples.chatper2_4;

public class JavaVMStackOOM {


    private int stackLength = 1;

    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(  ()-> {while(true){}} );
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        try{
            oom.stackLeakByThread();
        } catch (Throwable e) {
            System.out.println("stack oom:" );
            throw e;
        }
    }
}
