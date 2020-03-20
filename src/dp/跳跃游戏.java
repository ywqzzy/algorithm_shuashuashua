package dp;

public class 跳跃游戏 {
    public boolean canJump1(int[] nums) {
        if(nums == null) return false;
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = false;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--) {
            if(nums[i] + i >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
