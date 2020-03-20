package linkedlist;

public class 回文链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        ListNode cur = slow.next;
        ListNode pre = null;
        slow.next = null;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        while (pre != null) {
            if (start.val != pre.val) {
                return false;
            }
            start = start.next;
            pre = pre.next;
        }
        return true;
    }

}
