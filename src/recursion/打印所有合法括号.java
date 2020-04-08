package recursion;

import java.util.ArrayList;
import java.util.List;

public class 打印所有合法括号 {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(1, 0, n, "(");
        return res;
    }

    void dfs(int leftCnt, int rightCnt, int n, String s) {
        if(leftCnt == n && rightCnt == n) {
            res.add(s);
            return;
        }
        if(leftCnt < rightCnt) return;
        if(leftCnt < n) dfs(leftCnt+1, rightCnt,n, s + "(");
        if(rightCnt < leftCnt){
//            dfs(leftCnt + 1, rightCnt, n, s + "(" );
            dfs(leftCnt, rightCnt+1,n,s+")");
        }
    }
}
