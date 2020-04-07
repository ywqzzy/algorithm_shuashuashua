package arr;

public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int [][]res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int cur = 1;
        while(cur <= n * n) {
            for(int i = left; i <= right; i++) res[top][i] = cur++;
            top++;
            for(int i = top; i <= bottom; i++) res[i][right] = cur++;
            right--;
            for(int i = right; i >= left; i--) res[bottom][i] = cur++;
            bottom--;
            for(int i = bottom; i >= top;i--) res[i][left] = cur++;
            left++;
        }
        return res;
    }
}
