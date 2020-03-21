package double_pointer;

public class 移动零 {
    public void moveZeros(int[] nums) {
        if(nums == null) return;
        int tail = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, tail);
                tail++;
            }
        }
    }
    public void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
