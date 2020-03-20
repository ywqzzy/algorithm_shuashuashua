package binary_tree;

public class 二叉树的直径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int res = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        helper(root);
        return res - 1;
    }

    int helper(TreeNode node) {
        if(node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        res = Math.max(l + r + 1 , res);
        return Math.max(l, r) + 1;
    }
}
