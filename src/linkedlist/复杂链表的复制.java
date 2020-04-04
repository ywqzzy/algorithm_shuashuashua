package linkedlist;

import java.util.HashMap;

public class 复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    // map 解法
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null) {
            Node node = getNode(cur);
            node.next = getNode(cur.next);
            node.random = getNode(cur.random);
            cur = cur.next;
        }
        return getNode(head);
    }

    Node getNode(Node node) {
        if(node == null) return null;
        if(!map.containsKey(node)) {
            Node temp = new Node(node.val);
            map.put(node, temp);
        }
        return map.get(node);
    }


    // 原地解法
}
