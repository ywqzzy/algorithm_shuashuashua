package binary_tree;

public class 二叉树的镜像 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode temp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(temp);
        return root;
    }
}
