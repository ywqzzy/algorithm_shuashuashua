package union_find;

import java.util.ArrayList;
import java.util.List;

public class 朋友圈 {
    List<Integer> p = new ArrayList<>();
    int find(int x) {
        if(p.get(x) != x) p.set(x, find(p.get(x)));
        return p.get(x);
    }
    public int findCircleNum(int[][] M) {
        p = new ArrayList<>();
        int n = M.length;
        for(int i = 0; i < n; i++) p.add(i);
        int res = n;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(M[i][j] == 0) continue;
                if(find(i) != find(j)) {
                    res--;
                    p.set(find(i), find(j));
                }
            }
        }
        return res;
    }
}
