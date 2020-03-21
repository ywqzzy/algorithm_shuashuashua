package arr;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    // 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 灵魂拷问
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) res.add(i+1);
        }
        return res;
    }
}
