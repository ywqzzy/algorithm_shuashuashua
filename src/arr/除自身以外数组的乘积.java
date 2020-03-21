package arr;

public class 除自身以外数组的乘积 {
    // 不使用除法 空间复杂度为常数。。。。
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++) {
            res[i] = k; // 这个数左边的乘积
            k *= nums[i];
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] *= k; // 这个数右边的乘积
            k *= nums[i];
        }
        return res;
    }
}
