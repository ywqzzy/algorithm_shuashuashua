package arr;

public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int w = matrix[0].length;
        int h = matrix.length;
        int []res = new int[w * h];
        int top = 0, bottom = h - 1, left = 0, right = w - 1;
        int idx = 0;
        while(true) {
            for(int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            } // left ---> right
            top++;
            if(top > bottom) break;
            for(int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            } // top ---> bottom
            right--;
            if(right < left) break;
            for(int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            } // right ---> left
            bottom--;
            if(top > bottom) break;
            for(int i = bottom; i>=top; i--) {
                res[idx++] = matrix[i][left];
            } // bottom ---> top
            left++;
            if(right < left) break;
        }
        return res;
    }
}
