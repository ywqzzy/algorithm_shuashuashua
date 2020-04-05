package binary_search;

public class 寻找左侧边界的二分搜索 {
    int left_bound(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; //  not nums.length - 1
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid;  // why?  左闭右开
            }
        }
        if(left == nums.length) return -1;
        return nums[left] == target ? left : -1; // 返回right 也可
    }

    int left_bound1(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
}
