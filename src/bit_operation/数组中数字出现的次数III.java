package bit_operation;

public class 数组中数字出现的次数III {
    public int[] singleNumbers(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        int lastOne = res &(-res);
        int res1 = 0, res2 = 0;
        for(int num: nums) {
            if((num&lastOne) == lastOne) res1^=num;
            else res2^=num;
        }
        return new int[]{res1^0, res2^0};
    }
}
