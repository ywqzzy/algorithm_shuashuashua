package arr;

public class 旋转矩阵 {
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int mid = n >> 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }


    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // 角矩形长宽
        int height = N / 2;
        int width = N % 2 == 0 ? N / 2 : N / 2 + 1;
        // 换角
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i]; // 左下角对应的位置
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j]; // 右下角对应的位置
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i]; // 右上角对应的位置
                matrix[j][N - 1 - i] = temp;
            }
        }
    }

//    作者：caoPhoenix
//    链接：https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/tu-jie-ru-he-que-ding-xuan-zhuan-hou-de-zuo-biao-b/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
