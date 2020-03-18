package binary_tree;

public class 二叉树展开为链表 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public void flatten(TreeNode root) {
        flat(root);
    }
    public TreeNode flat(TreeNode root) {
        if(root == null) return null;

        TreeNode temp1 = root.right;
        root.right = flat(root.left);
        root.left = null;
        TreeNode temp = root;
        while(temp != null) {
            temp = temp.right;
        }
        temp.right = flat(temp1);

        return root;
    }
}
