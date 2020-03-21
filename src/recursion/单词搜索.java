package recursion;

public class 单词搜索 {
    int []dx = {-1, 0, 1, 0};
    int []dy = {0, 1, 0, -1};
    int n;
    int m;

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 ||  board[0].length == 0) return false;
        n = board.length;
        m = board[0].length;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) if(dfs(board, i, j, word, 0)) return true;
        return false;
    }

    boolean dfs(char[][] board, int tx, int ty, String word, int curIdx) {
        if(board[tx][ty] != word.charAt(curIdx)) return false;

        if(curIdx == word.length() - 1) return true;

        char temp = board[tx][ty];
        board[tx][ty] = '*';
        for(int i = 0; i < 4; i++) {
            int xx = tx + dx[i];
            int yy = ty + dy[i];
            if(xx >= 0 && xx < n && yy < m && yy >= 0 && board[xx][yy] != '*') {
                if(dfs(board, xx, yy, word, curIdx + 1) == true) return true;
            }
        }
        board[tx][ty] = temp;
        return false;
    }
}


