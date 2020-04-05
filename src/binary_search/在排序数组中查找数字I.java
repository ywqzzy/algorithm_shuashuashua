package binary_search;

public class 在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == target ? 1: 0;
        int start = left_bound(nums, target);
        if(start == -1) return 0;
        int end = right_bound(nums, target);
        return end - start + 1;
    }

    int left_bound(int[] nums, int target) {
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
