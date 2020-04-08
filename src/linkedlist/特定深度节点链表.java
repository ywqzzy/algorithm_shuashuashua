package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 特定深度节点链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return new ListNode[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> list = new ArrayList<>();
        ListNode head = new ListNode(0), cur = head; // dummy
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(head.next);
            head = new ListNode(0);
            cur = head;
        }
        ListNode[] res = new ListNode[list.size()];
        int idx = 0;
        for(int i = 0; i < list.size(); i++) res[idx++] = list.get(i);
        return res;
    }
}
