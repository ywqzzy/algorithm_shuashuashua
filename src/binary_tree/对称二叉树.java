package binary_tree;

public class 对称二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root, root);
    }

    boolean helper(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1.val != n2.val) return false;
        else return helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }

}
