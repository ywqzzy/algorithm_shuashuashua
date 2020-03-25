package dp;

public class 丑数 {

    public int[] res = new int[1690];
    public int nthUglyNumber(int n) {
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;
        res[0] = 1;
        for(int i = 1; i < 1690; i++) {
            int t = Math.min(Math.min(res[num2] * 2, res[num3] * 3), res[num5] * 5);
            res[i] = t;
            if(t == res[num2] * 2) num2++;
            if(t == res[num3] * 3) num3++;
            if(t == res[num5] * 5) num5++;
        }
        return res[n-1];
    }
}
