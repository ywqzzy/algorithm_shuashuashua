package double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = len - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L+1]) L++;
                    while(L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                } else if(sum < 0) L++;
                else if(sum > 0) R--;
            }
        }
        return res;
    }
}
