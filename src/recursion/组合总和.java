package recursion;

import java.util.ArrayList;
import java.util.List;
// 这种贼不熟  需要好好熟练一下！！！
public class 组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer> > combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0 || target < 0) return res;
        List<Integer> list = new ArrayList<>();
        helper(0, candidates, target, list);
        return res;
    }

    void helper(int start, int[] candidates, int target, List<Integer> list) {
        if(target < 0) return;
        if(target == 0) res.add(new ArrayList<>(list));
        else {
            for(int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                helper(i, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }


}
