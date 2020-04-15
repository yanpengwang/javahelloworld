package understandjvm.examples.chapter2_3;

import java.util.ArrayList;
import java.util.List;
public class HeapOOM {
    static class OOMObject {
        int a = 1;
    }


    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
            //break;
        }
    }
}
