package dp;

public class 按摩师 {
    // 1、二维状态
    public int massage1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 0) return nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    // 2、1维状态变量
    public int massage2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    // 3. 滚动数组 根据法一  这个引入了临时变量
    public int massage3(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        if(len == 0) return nums[0];
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int old, now = 0;
        for(int i = 1; i < len; i++) {
            old = now;
            now = 1 - now;
            dp[now][0] = Math.max(dp[old][0], dp[old][1]);
            dp[now][1] = dp[old][0] + nums[i];
        }
        return Math.max(dp[now][0], dp[now][1]);
    }

    // 4. 滚动数组 根据法一  没有引入临时变量 利用位运算
    public int massage4(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        if(len == 0) return nums[0];
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i = 1; i < len; i++) {

            dp[i&1][0] = Math.max(dp[(i-1)&1][0], dp[(i-1)&1][1]);
            dp[i&1][1] = dp[(i-1)&1][0] + nums[i];
        }
        return Math.max(dp[(len-1)&1][0], dp[(len-1)&1][1]);
    }

    // 5. 滚动数组 根据法2 这下空间就贼小
    public int massage(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return nums[0];

        int[] dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i % 3] = Math.max(dp[(i-1)%3], dp[(i-2)%3] + nums[i]);
        }
        return dp[(len-1)%3];
    }

}
