import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    int nn;
    public List<String> generateParenthesis(int n) {
        nn = n;
        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    public void dfs(List<String> result, int leftCnt, int rightCnt, String s) {
        if(leftCnt == 0 && rightCnt == 0) result.add(s);
        if(leftCnt > rightCnt) return;
        if(leftCnt > 0) dfs(result, leftCnt - 1, rightCnt, s+"(");
        if(rightCnt > 0) dfs(result, leftCnt, rightCnt - 1, s+")");
    }

    public static void main(String[] args) {
        括号生成 main = new 括号生成();
        List<String> res = main.generateParenthesis(3);
        System.out.println();
    }
}
