import java.util.Scanner;

public class 子集和问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            System.out.println(solve(a, n));
        }
    }

    private static int solve(int[] a, int n) {
        int[][] dp = new int[105][(1<<10)];//dp数组的含义：遍历到输入数组a的第i个元素且当前子集内有哪些数的状态为j时，此时子集和的最大值
        int tempMask = getMask(a[0]);
        dp[0][tempMask] = a[0];
        for(int i = 1; i < n; i++) {
            int mask = getMask(a[i]);  // 首先先把当前遍历到的数转化为2进制掩码的表示形式 如35转化为0000101000
            for(int j = 0;j < (1<<10); j++) {  // 遍历所有的状态
                if( (j & mask) == mask) {  // 如果当前状态里面包含了当前数的掩码，
                    // 其实说明j表示的子集状态中包含a[i]里的数字
                    // 那么可以按照下面的公式进行更新
                    // 具体含义如下： 遍历到i且状态为j， 其实这个状态j可以有两种到达方式，
                    // 一种是将第i个数放入子集中，
                    // 一种是不把第i个数放入子集中，选遍历到i-1时的状态为j的
                    // 取这两者中的最大值来更新dp[i][j]
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j^mask] + a[i]);
                }
            }
        }
        // 其实本质上还是一个0-1背包的问题，j^mask表示选a[i]放入背包，j&mask表示能否放入背包
        int res = 0;
        for (int j = 0; j < (1<<10); j++) {
            res = Math.max(res,dp[n-1][j]);
        }
//        for (int x : a) {
//            for (int bits = dp.length-1; bits >= 0; bits--) {
//                int mask = getMask(x);
//                if ((bits & mask) == mask) {
//                    dp[bits] = Math.max(dp[bits], dp[bits^mask] + x); //
//                }
//            }
//        }  // 这个代码是滚动数组后的写法
        return res;
    }

    private static int getMask(int x) {
        int res = 0;
        while (x > 0) {
            int d = x % 10;
            res |= (1 << d);
            x /= 10;
        }
        return res;
    }
}
