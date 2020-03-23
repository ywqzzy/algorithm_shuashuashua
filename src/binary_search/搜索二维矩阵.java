package binary_search;

public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;
        int ti = 0;
        int tj = m - 1;

        while(ti < n && tj >= 0) {
            int temp = matrix[ti][tj];
            if(temp < target) {
                ti++;
            } else if(temp > target){
                tj--;
            } else return true;
        }
        return false;
    }
}
