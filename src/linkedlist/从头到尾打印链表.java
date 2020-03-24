package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 从头到尾打印链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    List<Integer> res = new ArrayList<>();
//    public int[] reversePrint(ListNode head) {
//        dfs(head);
//        int size = res.size();
//        int[] ans = new int[size];
//        for(int i = 0; i < res.size(); i++) ans[i] = res.get(i);
//        return ans;
//    }
//
//    public void dfs(ListNode head) {
//        if(head == null) return;
//        dfs(head.next);
//        res.add(head.val);
//    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++) ans[i] = stack.pop();
        return ans;
    }

}
