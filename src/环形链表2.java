public class 环形链表2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        boolean isCycle = false;
        ListNode res = head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                isCycle = true;
                ListNode n2 = head;
                while(slow != n2) {
                    n2 = n2.next;
                    slow = slow.next;
                }
                res = n2;
            }
        }
        return isCycle==true ? res: null;
    }
}
