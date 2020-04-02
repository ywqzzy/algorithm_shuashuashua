package recursion;

public class 矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, words, 0)) return true;
            }
        }
        return false;
    }
    int[] dx = {0,0,-1, 1};
    int[] dy = {1, -1, 0, 0};
    boolean dfs(char[][]board, int i, int j, char[] words, int idx) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != words[idx]) return false;
        if(idx == words.length - 1) return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = false;
        for(int k = 0; k < 4; k++) {
            int ti = i + dx[k];
            int tj = j + dy[k];
            if(dfs(board, ti, tj, words, idx + 1) == true) return true;
        }
        board[i][j] = temp;
        return res;
    }
}
