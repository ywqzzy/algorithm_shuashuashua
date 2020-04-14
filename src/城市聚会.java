import java.util.Scanner;

public class 城市聚会 {
    private int n, m, x;	// 顶点数，边数,在哪聚会
    int [][] dist;
    public void solve() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            dist = new int[n+1][n+1];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n;j++) {
                    if(i != j) dist[i][j] = Integer.MAX_VALUE;
                    else dist[i][j] = 0;
                }
            }
            x = sc.nextInt();
            for (int i = 0; i < m; ++i) {
                int xx = sc.nextInt();
                int yy = sc.nextInt();
                int cost = sc.nextInt();
                dist[xx-1][yy-1] = cost;
            }

            // floyd 算法开始
            for(int k = 0; k < n; k++){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        int temp = (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)?
                                Integer.MAX_VALUE: (dist[i][k] + dist[k][j]);
                        if(temp < dist[i][j]){
                            dist[i][j] = temp;
                        }
                    }
                }
            }
            int mx = 0;
            for(int i = 0; i < n; i++) {
                mx = Math.max(mx,dist[i][x-1] + dist[x-1][i]);
            }
            System.out.println(mx);
        }
    }

    public static void main(String[] args) {
        城市聚会 main = new 城市聚会();
        main.solve();
    }

    /*
     4 8 2
     1 2 4
     1 3 2
     1 4 7
     2 1 1
     2 3 5
     3 1 2
     3 4 4
     4 2 3
     */
}

