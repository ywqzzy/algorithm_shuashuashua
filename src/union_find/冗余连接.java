package union_find;

import java.util.ArrayList;
import java.util.List;

public class 冗余连接 {
    List<Integer> p;

    int find(int x) {
        if(p.get(x) != x) p.set(x, find(p.get(x)));
        return p.get(x);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new ArrayList<>();
        for(int i = 0; i <= n; i++) p.add(i);
        for(int i = 0; i < n; i++) {
            int a = edges[i][0], b = edges[i][1];
            if(find(a) == find(b)) return new int[]{a, b};
            p.set(find(a), find(b));
        }
        return new int[]{-1,-1};
    }

}
