package string;

public class 外观数列 {
    public String countAndSay(int n) {
        String res = "1";
        if(n == 1) return res;
        for(int i = 1; i <= n; i++) {
            res = helper(res);
        }
        return res;
    }
    String helper(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        char last = s.charAt(0);
        int cnt = 1;
        for(int i = 1; i < len; i++) {
            if(s.charAt(i) != last) {
                sb.append(cnt);
                sb.append(last);
                last = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cnt);
        sb.append(last);
        return sb.toString();
    }
}
