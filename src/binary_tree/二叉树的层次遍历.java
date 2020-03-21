package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的层次遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    List<List<Integer>> res;
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    void dfs(int level, TreeNode node, List<List<Integer>> res) {
        if(res.size() == level) res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        if(node.left!=null) dfs(level+1, node.left, res);
        if(node.right!=null) dfs(level+1, node.right, res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                temp.add(treeNode.val);
                if(treeNode.left!=null) queue.add(treeNode.left);
                if(treeNode.right!=null) queue.add(treeNode.right);
            }
            res.add(temp);
        }
        return res;
    }

}
