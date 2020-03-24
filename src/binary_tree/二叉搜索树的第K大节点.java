package binary_tree;

import java.util.Stack;

public class 二叉搜索树的第K大节点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int kthLargest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode t = stack.pop();
            if(count == k) return t.val;
            count ++;
            root = t.left;
        }
        return 0;
    }

//    int res = -1;
//    int cnt;
//    public int kthLargest(TreeNode root, int k) {
//        cnt = k;
//        dfs(root);
//        return res;
//    }
//
//    void dfs(TreeNode root) {
//        if(root == null) return;
//        dfs(root.right);
//        if(cnt == 1) {
//            res = root.val;
//            cnt --;
//            return;
//        }
//        cnt--;
//        dfs(root.left);
//    }
}
