package binary_tree;

public class 路径总和III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int pathSum(TreeNode root, int sum) {
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = 0;
        if(root.val == sum) res += 1;
        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }
}
