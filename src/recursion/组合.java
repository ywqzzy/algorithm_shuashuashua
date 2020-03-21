package recursion;


import java.util.ArrayList;
import java.util.List;

// leetcode 77
public class 组合 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(k == 0 || n == 0) return res;

        List<Integer> list = new ArrayList<>();
        helper(n, k, 1, list);
        return res;
    }

    public void helper(int n, int k, int start, List<Integer> list) {
        if(k == 0)  {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n - (k) + 1; i++) { // 剪枝
            list.add(i);
            helper(n, k-1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
