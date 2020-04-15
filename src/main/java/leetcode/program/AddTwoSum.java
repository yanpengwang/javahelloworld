package leetcode.program;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class AddTwoSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode node = head;
        Integer save = 0, sum = 0;
        while(l1 != null || l2 != null || save !=0 ) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + save;
            ListNode curNode = new ListNode(sum % 10);
            save = sum / 10;
            node.next = curNode;
            node = curNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head.next;
    }

    public static void main(String[] args) {

        List<Integer> l1 = asList(2, 4, 3);
        List<Integer> l2 = asList(5, 6, 4);

        ListNode input1 =  ListNode.buildMultiNodes(l1);
        ListNode input2 =  ListNode.buildMultiNodes(l2);

        ListNode ans = new AddTwoSum().addTwoNumbers(input1, input2);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}


