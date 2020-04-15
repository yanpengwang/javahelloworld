package leetcode.program;


import java.util.List;

public class  ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static ListNode buildMultiNodes(List<Integer> intList) {
        if (intList.size() == 0) {
            return null;
        }
        ListNode headNode = new ListNode(intList.get(0));
        ListNode preNode = headNode;
        for(int i = 1; i < intList.size(); i++) {
            ListNode newNode = new ListNode(intList.get(i));
            preNode.next = newNode;
            preNode = newNode;
        }
        return headNode;
    }
}




