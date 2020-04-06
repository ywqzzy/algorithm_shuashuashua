package dp.划分型;

public class 解码方法 {
    public int numDecodings(String s) {
        char[] sarr = s.toCharArray();
        int len = s.length();
        if(len == 0) return 1;
        if(sarr[0] == '0') return 0;
        int[] dp=new int[len+1];
        dp[0]=1;
        for(int i=1;i<=len;i++) {
            dp[i] = 0;
            if(sarr[i-1] >='1' && sarr[i-1]<='9') {
                dp[i] += dp[i-1];
            }
            if(i > 1) {
                int j = 10*(sarr[i-2]-'0') + (sarr[i-1] - '0');
                if(sarr[i-2] !='0' && j>=10 && j<=26) dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }
}
