package recursion;

public class 机器人的运动范围 {
    // 不能移动到方格外, 也不能进入行坐标和列坐标的数位之和大于 k 的格子
    int m;
    int n;
    int k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        if(check(i, j) == false) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    boolean check(int i, int j) {
        if(i > m - 1 || j > n - 1 || visited[i][j] == true) return false;
        int sum = 0;
        while(i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while(j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }
}
