import java.util.Scanner;

public class baidu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            long []a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long res = 0;
            for(int i = 0; i < n; i++) {
                double temp = (a[i] - (long)n + 1L) / ((long)n - 1);
                if(temp < 0) continue;
                System.out.println(temp);
                res += Math.ceil(temp);
            }
            System.out.println(res);
        }
    }
}
