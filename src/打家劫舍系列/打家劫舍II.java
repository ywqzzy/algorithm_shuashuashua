package 打家劫舍系列;

public class 打家劫舍II {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int[]dp1 = new int[nums.length - 1];
        int[]dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length - 1;i++){
            dp1[i] = Math.max(dp1[i - 1],dp1[i - 2]+nums[i]);
        }
        dp2[0] = 0;
        dp2[1] = Math.max(0,nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp2[i] = Math.max(dp2[i - 1],dp2[i - 2]+nums[i]);
        }
        return Math.max(dp1[dp1.length - 1],dp2[dp2.length - 1]);
    }
//    public int rob1(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        if(nums.length == 1) return nums[0];
//        if(nums.length == 2) return Math.max(nums[0], nums[1]);
//
//        int[] num = new int[nums.length * 2];
//        for(int i = 0; i < nums.length; i++) num[i] = nums[i];
//        for(int i = 0; i < nums.length; i++) num[i + nums.length] = nums[i];
//
//        int [][]dp = new int[nums.length][nums.length];
//        for(int i = 0; i < nums.length; i++) {
//            dp[i][0] = num[i];
//            dp[i][1] = Math.max(num[0], num[1]);
//            for(int j = 2 + i,len = 3; len < nums.length; j++, len++) {
//                dp[i][j] = Math.max(dp[i][j-1], num[j] + dp[i][len-2]);
//            }
//        }
//        int res = 0;
//        for(int i = 0; i < nums.length; i++) {
//            res = Math.max(dp[i][nums.length], res);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        打家劫舍II main = new 打家劫舍II();
        System.out.println(main.rob(new int[]{2,3,2}));
    }
}
