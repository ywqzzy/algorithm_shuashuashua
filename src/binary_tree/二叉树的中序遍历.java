package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    // Recursive
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        res.addAll(inorderTraversalRecursive(root.left));
        res.add(root.val);
        res.addAll(inorderTraversalRecursive(root.right));
        return res;
    }

    // iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode leftMost = stack.pop();
            res.add(leftMost.val);
            cur = leftMost.right;
        }
        return res;
    }
}
