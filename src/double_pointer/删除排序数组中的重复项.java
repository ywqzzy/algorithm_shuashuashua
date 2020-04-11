package double_pointer;

public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        // 原地
        if(nums.length == 0) return 0;
        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) nums[k++] = nums[i];
        }
        return k;
    }
}
