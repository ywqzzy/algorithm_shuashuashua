package binary_tree;

public class 判断是否是二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(0, postorder.length-1, postorder);
    }
    boolean dfs(int start, int end, int[] postorder) {
        if(start >= end) return true;
        int idx = start;
        while(postorder[idx] < postorder[end]) idx++;
        int mid = idx;
        while(postorder[idx] > postorder[end]) idx++;
        return idx == end && dfs(start, mid-1, postorder) && dfs(mid, end-1, postorder);
    }
}
