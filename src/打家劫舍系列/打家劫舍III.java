package 打家劫舍系列;

public class 打家劫舍III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

//    public int rob(TreeNode root) {
//        if(root == null) return 0;
//        return helper(root, false);
//    }
//
//    public int helper(TreeNode node, boolean isRootUsed) {
//        if(node == null) return 0;
//        if(isRootUsed) {
//            return helper(node.left, false) + helper(node.right, false);
//        } else {
//            int res1 = helper(node.left, false) + helper(node.right, false);
//            int res2 = node.val + helper(node.left, trie) + helper(node.right, trie);
//            return Math.max(res1, res2);
//        }
//    }
//  时间复杂度太高了 逃。。。
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        if(root == null) return new int[2];
        int[] res = new int[2];

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;

        return res;
    }
}
