package arr;

public class 可以被一步捕获的棋子数 {
    public int numRookCaptures(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return 0;
        int res = 0;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R') {

                    int x = i, y = j;
                    int curx = x + 1, cury;
                    // 向下
                    while(curx < n) {
                        if(board[curx][y] == 'B') break;
                        else if(board[curx][y] == 'p') {
                            res++;
                            break;
                        }
                        curx++;
                    }
                    curx = x - 1;
                    while(curx >= 0) {
                        if(board[curx][y] == 'B') break;
                        else if(board[curx][y] == 'p') {
                            res++;
                            break;
                        }
                        curx--;
                    }

                    cury = y + 1;
                    while(cury < m) {
                        if(board[x][cury] == 'B') break;
                        else if(board[x][cury] == 'p') {
                            res++;
                            break;
                        }
                        cury++;
                    }

                    cury = y - 1;
                    while(cury >= 0) {
                        if(board[x][cury] == 'B') break;
                        else if(board[x][cury] == 'p') {
                            res++;
                            break;
                        }
                        cury--;
                    }
                    return res;
                }
            }
        }
        return 0;
    }



}
