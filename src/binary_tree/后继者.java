package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 后继者 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 递归  利用 BST 性质
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(p.val >= root.val) {
            return inorderSuccessor1(root.right, p);
        } else {
            TreeNode left = inorderSuccessor1(root.left, p);
            if(left != null) return left;
            else return root;
        }
    }

    // 递归 不利用 BST 性质
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        List<TreeNode> res = new ArrayList<>();
        inorder(root, res);
        res.add(null);  // 最后一个节点的后继肯定是空了
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i) == p) return res.get(i + 1);
        }
        return null;
    }

    void inorder(TreeNode root, List<TreeNode> res) {
        if(root.left != null) inorder(root.left, res);
        res.add(root);
        if(root.right != null) inorder(root.right, res);
    }


    // 非递归 利用 BST 性质
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        if(p.right != null) {
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        }
        TreeNode res = null;
        while(root != p) {
            if(root.val < p.val) root = root.right;
            else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    // 非递归 不利用 BST 性质
    public TreeNode inorderSuccessor4(TreeNode root, TreeNode p) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while(!st.empty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.peek();  // leftMost
            res.add(root.val);
            if(root == p) idx = res.size();
            st.pop();
            root = root.right;
        }

        if(idx == 0 || idx == res.size()) return null;
        else return new TreeNode(res.get(idx));
    }

    // TODO MORRIS 遍历 暂时还不会这玩意
}
