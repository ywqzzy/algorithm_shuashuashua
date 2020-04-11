package double_pointer;

public class 最长有效括号 {
    //1. 每个左括号对应的括号固定
    //2. 括号序列合法  <=> 所有前缀和 >= 0, 且总和 = 0  nb！ ( = 1   ) = -1

    // 如果 cnt < 0 start = i + 1, cnt = 0
    // cnt > 0 go on
    // cnt == 0  [start,i]  合法 更新最大值
    // 再反着做一遍  tql!!!!

    int helper(String s) {
        int res = 0;
        int start = 0, cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') cnt++;
            else {
                cnt--;
                if(cnt < 0) {
                    start = i + 1;
                    cnt = 0;
                } else if(cnt == 0) {
                    res = Math.max(res, i - start + 1);
                }
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        int res = helper(s);

        s = new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return Math.max(helper(sb.toString()), res);
    }
}
