package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 寻找重复的子树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int cnt = 0;
    Map<String, Integer> hash;
    Map<Integer, Integer> count;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        count = new HashMap<>();
        hash = new HashMap<>();
        hash.put("#", ++cnt);
        dfs(root);
        return res;
    }

    String dfs(TreeNode root) {
        if(root == null) String.valueOf(hash.get("#"));
        String left = dfs(root.left);
        String right = dfs(root.right);
        String tree = String.valueOf(root.val) + ',' + left + ',' + right;
        if(hash.get(tree) == null) {
            hash.put(tree, ++cnt);
        }
        int t = hash.get(tree);
        count.put(t, count.getOrDefault(t, 0) + 1);
        if(count.get(t) == 2) res.add(root);

        return String.valueOf(t);
    }


}
