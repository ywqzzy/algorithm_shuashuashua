package recursion;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class 两两交换链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode node) {
        if(node.next == null) return node;
        ListNode temp = node.next.next;
        ListNode head = node.next;
        head.next = node;
        ListNode res = swapPairs(temp);
        node.next = res;
        return head;
    }
}
