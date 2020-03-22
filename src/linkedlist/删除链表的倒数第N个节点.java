package linkedlist;

public class 删除链表的倒数第N个节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode pre = null;
        ListNode slow = head;
        int count = 0;
        while(fast != null && count < n) {
            fast = fast.next;
            count ++;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return head;
    }

}
