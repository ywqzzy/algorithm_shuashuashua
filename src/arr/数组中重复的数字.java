package arr;

public class 数组中重复的数字 {
    // hash 太简单了 我觉得不行 必须想到更好的解法
    // set 也太简单了 我也觉得不行

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
