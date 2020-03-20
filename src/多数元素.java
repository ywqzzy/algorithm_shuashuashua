public class 多数元素 {

    // 摩尔投票 正确性证明。。。不太会
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int majority = nums[0];
        int count = 0;
        for(int i = 1;i < len; i++) {
            if(count == 0) majority = nums[i];
            if(nums[i] == majority) count ++;
            else count--;
        }
        return majority;
    }
}
