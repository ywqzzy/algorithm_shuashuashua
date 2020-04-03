package binary_tree;

public class 树的子结构 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;
        if(A == null) return false;
        if(check(A,B) == true) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean check(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return check(A.left, B.left) && check(A.right, B.right);
    }
}
