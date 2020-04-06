package recursion;

import java.util.ArrayList;
import java.util.List;

public class 无重复字符串的排列组合 {


    // 常规写法
    List<String> resl = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    boolean[] visited = new boolean[10];
    public String[] permutation1(String s) {
        dfs1(s);
        String[] res = new String[resl.size()];
        for(int i = 0; i < resl.size(); i++) {
            res[i] = resl.get(i);
        }
        return res;
    }


    void dfs1(String s) {
        if(path.length() == s.length()) {
            resl.add(new String(path.toString()));
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            if(!visited[i]) {
                path.append(s.charAt(i));
                visited[i] = true;
                dfs1(s);
                visited[i] = false;
                path.deleteCharAt(path.length()-1);
            }
        }
    }


    // swap 写法
    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        dfs(s.toCharArray(), 0);
        String[] result = new String[res.size()];
        for(int i = 0; i < result.length; i++) result[i] = res.get(i);
        return result;
    }

    void dfs(char[] arr, int start) {
        if(start == arr.length - 1) {
            res.add(new String(arr));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            dfs(arr, start + 1);
            swap(arr, start, i);
        }
    }

    void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
