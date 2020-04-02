package linkedlist;

public class 两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode anode = headA, bnode = headB;
        int len = 0;
        while(anode != null) {
            len++;
            anode = anode.next;
        }
        while(bnode != null) {
            len--;
            bnode = bnode.next;
        }
        if(len > 0) anode = headA;
        else anode = headB;
        if(anode == headA) {
            bnode = headB;
        } else bnode = headA;
        len = Math.abs(len);
        while(len > 0) {
            anode = anode.next;
            len--;
        }
        while(anode != bnode) {
            anode = anode.next;
            bnode = bnode.next;
        }
        return anode;
    }

}
