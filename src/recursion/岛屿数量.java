package recursion;

public class 岛屿数量 {
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    int n,m;
    boolean [][]visited;
    char[][] mygrid;
    public int numIslands(char[][] grid) {
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;

        visited = new boolean[n][m];
        mygrid = grid;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    cnt ++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(int row, int col) {
        visited[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int xx = row + dx[i];
            int yy = col + dy[i];
            if(xx< 0 || xx>=n || yy < 0 || yy>=m || mygrid[xx][yy] !='1' || visited[xx][yy] == true) continue;
            dfs(xx, yy);
        }
    }
}
