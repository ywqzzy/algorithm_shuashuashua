package dp;

public class 回文子串 {

    // 计算有多少个回文子串

    // O(n^2) 解法
    public int countSubstrings1(String s) {
        if(s == null) return 0;
        if(s.length() == 0 || s.length() == 1) return s.length();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j; i++) {
                if(i == j) {
                    dp[i][j] = true; res++;
                } else {
                    if(s.charAt(i) == s.charAt(j) && (j-i <= 1 || dp[i+1][j-1] == true)) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    // 马拉车 我选择暂时不看。。。。
    public int countSubstrings(String s) {
        return 0;
    }

}
