package binary_search;

public class 寻找旋转排序数组中的最小值 {
    // 不存在重复元素
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            if(nums[left] <= nums[right]) return nums[left];
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
