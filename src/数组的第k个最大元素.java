public class 数组的第k个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, k - 1);
    }

    public int find(int[] nums, int low, int high, int k) {
        int index = partition(nums, low, high, k);
        if(index == k) return nums[index];
        else if(index > k) return find(nums, low, index -1, k);
        else return find(nums, index + 1, high, k);
    }
    int partition(int[] nums, int low, int high, int k) {
        int pivot = nums[low];
        while(low < high) {
            while(low < high && nums[high] <= pivot) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] >= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
