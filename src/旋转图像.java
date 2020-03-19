public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int temp;
        for(int start = 0, end = matrix[0].length; start < end; start++, end--) {
            for(int s = start, e =end;s < end; s++,e--) {
                temp = matrix[start][s];
                matrix[start][s] = matrix[e][start];
                matrix[e][start] = matrix[end][e];
                matrix[end][e] = matrix[s][end];
                matrix[s][end] = temp;
            }
        }
    }
}
