public class 最长回文子序列 {

    public int longestPalindromeSubseq(String s) {
        int [][]dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) dp[i][i] = 1;
        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = Math.max(dp[i+1][j-1] + 2, dp[i][j]);
                 else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new 最长回文子序列().longestPalindromeSubseq("bbbab"));
    }
}
