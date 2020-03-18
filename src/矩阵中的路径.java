public class 矩阵中的路径 {
    boolean flag = false;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        flag = false;
        if(matrix == null || matrix.length == 0) return false;
        if(str == null || str.length == 0) return false;
        boolean[][]visited = new boolean[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(matrix[i * cols + j] == str[0]){
                    ddddfs(i,j,matrix,rows,cols,str,visited,0);
                    if(flag == true) return true;
                }
            }
        }
        return false;
    }
    public void ddddfs(int i,int j,char[]matrix,int rows,int cols,char[]str,boolean[][]visited,int count){
        if(i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] == true || str[count] != matrix[i * cols + j]) return;
        if(count == str.length - 1 ) {
            flag = true;
            return;
        }
        visited[i][j] = true;
        count++;
        ddddfs(i + 1,j,matrix,rows,cols,str,visited,count);
        ddddfs(i - 1,j,matrix,rows,cols,str,visited,count);
        ddddfs(i,j + 1,matrix,rows,cols,str,visited,count);
        ddddfs(i,j - 1,matrix,rows,cols,str,visited,count);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char []matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char []str = {'A','B','C','C','E','D'};
        Boolean ans = new 矩阵中的路径().hasPath(matrix,3,4,str);
        System.out.println(ans);
    }


}