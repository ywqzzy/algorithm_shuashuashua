package hash;

import java.util.HashMap;

public class 和为k的子数组 {

//    垃圾暴力解法
//    int res = 0;
//    public int subarraySum(int[] nums, int k) {
//        res = 0;
//        for(int i = 0; i < nums.length; i++) dfs(nums, i, k);
//        return res;
//    }
//
//    void dfs(int[] nums, int start, int k) {
//        if(start >= nums.length) return;
//        if(k - nums[start]== 0) {
//            res ++;
//        }
//        dfs(nums, start + 1, k - nums[start]);
//    }
    // 前缀和  仍然很垃圾
//    public int subarraySum(int[] nums, int k) {
//        int []prefixSum = new int[nums.length + 1];
//        prefixSum[0] = 0;
//        int res = 0;
//        for(int i = 1; i <= nums.length; i++) {
//            prefixSum[i] = prefixSum[i-1] + nums[i-1];
//        }
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = i + 1; j <= nums.length; j++) {
//                if(prefixSum[j] - prefixSum[i] == k) res++;
//            }
//        }
//        return res;
//    }
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
