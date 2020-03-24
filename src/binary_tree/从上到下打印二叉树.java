package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            res.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;
    }
}
