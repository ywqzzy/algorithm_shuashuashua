package binary_tree;

public class 平衡二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int depthDiff = Math.abs(depth(root.left) - depth(root.right));
        if(depthDiff > 1) return false;
        if(isBalanced(root.left) && isBalanced(root.right)) return true;
        return false;
    }

    int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
