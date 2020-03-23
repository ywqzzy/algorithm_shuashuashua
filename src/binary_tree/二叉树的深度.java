package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的深度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
//    int res = 0;
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        res = 0;
//        res = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//        return res;
//    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int res = 0;
        q.offer(root);
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }
        }
        return res;
    }
}
