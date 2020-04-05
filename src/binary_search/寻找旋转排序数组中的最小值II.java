package binary_search;

public class 寻找旋转排序数组中的最小值II {

    // 元素可重复
    // TODO 2刷 此题太难了！！！！
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else if(nums[mid] < nums[right]) right = mid;
            else if(nums[mid] == nums[right]) {
                right--;
            }
        }
        return nums[left];
    }
}
