public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for(; i >=0; i--) {
            if(nums[i] < nums[i+1]) break;
        }
        if( i >= 0) {
            int end = nums.length - 1;
            for( ; end >=0; end--) {
                if(nums[end] > nums[i]) break;
            }
            swap(nums, i, end);
        }
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int low) {
        int high = nums.length - 1;
        while(low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
