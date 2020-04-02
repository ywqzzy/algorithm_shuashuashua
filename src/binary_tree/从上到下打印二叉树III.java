package binary_tree;

import java.util.*;

public class 从上到下打印二叉树III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        while(!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            if(flag == false) {
                Collections.reverse(temp);
            }
            flag = !flag;
            res.add(temp);
        }
        return res;
    }
}
