package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode node, int sum) {
        if(node == null) return;
        temp.add(node.val);
        sum -= node.val;
        if(sum == 0 && node.left == null && node.right == null) res.add(new ArrayList<>(temp));
        dfs(node.left, sum);
        dfs(node.right, sum);
        temp.remove(temp.size() - 1);
    }

}
