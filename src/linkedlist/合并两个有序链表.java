package linkedlist;

public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 这写的什么狗屎。。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res;
        ListNode temp;

        if(l1.val < l2.val) {
            res = l1;
            temp = res;
            l1 = l1.next;
        } else {
            res = new ListNode(l2.val);
            temp = res;
            l2 = l2.next;
        }

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
            }
        }
        if(l1 == null) {
            while (l2 != null) {
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(l2 == null) {
            while(l1 != null) {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            }
        }
        return res;
    }

}
