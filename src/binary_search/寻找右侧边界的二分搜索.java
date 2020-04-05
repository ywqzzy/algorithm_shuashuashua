package binary_search;

public class 寻找右侧边界的二分搜索 {
    public int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                left = mid + 1;
            }
        }
        if(right < 0 || nums[right] != target) return -1;
        return right;
    }
}
