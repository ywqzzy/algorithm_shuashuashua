package dp;

public class 最长回文子串 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;

        boolean [][]dp = new boolean[len][len];
        for(int i = 0; i < len; i++) dp[i][i] = true;
        int maxLen = 1;
        int start = 0;

        for(int j = 1; j < len; j++) {
            for(int i = 0; i < j; i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
    }
}
