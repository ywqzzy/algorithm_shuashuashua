public class 相交链表 {


     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if(headA == null || headB == null) return null;
         ListNode tempA = headA;
         ListNode tempB = headB;
         while ( tempA!= tempB) {
            tempA = tempA != null ? tempA.next : headB;
            tempB = tempB != null ? tempB.next : headA;
        }
        return tempA;
    }
}
