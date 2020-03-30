package double_pointer;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            while(start < end && (nums[start] & 1) == 1) start++;
            while(start < end && (nums[end] & 1) == 0) end--;
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        return nums;
    }
}
