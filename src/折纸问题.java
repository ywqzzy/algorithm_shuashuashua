import java.util.*;

public class 折纸问题 {
    void dfs(int cur,int n,boolean down) {
        if(cur > n) return;
        dfs(cur+1,n,true);
        ans.add(down?"down":"up");
        dfs(cur+1,n,false);
    }
    private List<String> ans = new ArrayList<>();

    public String[] foldPaper(int n) {
        // write code here
        dfs(1,n,true);
        return (String[]) ans.toArray();
    }
}