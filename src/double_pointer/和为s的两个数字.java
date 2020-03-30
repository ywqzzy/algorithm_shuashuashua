package double_pointer;

public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum < target) start++;
            else if(sum > target) end--;
            else return new int[]{nums[start], nums[end]};
        }
        return new int[0];
    }
}
