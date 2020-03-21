package binary_tree;

import java.util.Stack;

public class 验证二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST1(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long low, long high) {
        if(root == null) return true;
        if(root.val <= low) return false;
        if(root.val >= high) return false;
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }

    long lastVal = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        return dfsInOrder(root);
    }

    public boolean dfsInOrder(TreeNode root) {
        if(root == null) return true;
        if(!dfsInOrder(root.left)) return false;
        if(root.val <= lastVal) return false;
        lastVal = (long)root.val;
        if(!dfsInOrder(root.right)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long lastVal = Long.MIN_VALUE;

        while(!stack.empty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= lastVal) return false;
            lastVal = root.val;
            root = root.right;
        }
        return true;
    }

}
