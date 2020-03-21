package binary_tree;

public class LCA {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null && root != p && root!= q) return null;
        if(root == p || root == q) return root;
        if(left != null && right != null) return root;
        if(left == null) return right;
        else return left;
    }

    // TODO 迭代法
    // 1. 有父指针的迭代
    // 2. 无父指针的迭代

}
