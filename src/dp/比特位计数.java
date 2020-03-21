package dp;

public class 比特位计数 {
    // 时间复杂度O(n * sizeof(integer)) easy,O(n)才是最优解
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int i = 0;
        int x = 1;
        while(x <= num) {
            while(i < x && i + x <= num) {
                res[i + x] = res[i] + 1;
                i++;
            }
            i = 0;
            x <<= 1;
        }
        return res;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i<=num; i++) {
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }

    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i<=num; i++) res[i] = res[i&(i-1)] + 1;
        return res;
    }
}
