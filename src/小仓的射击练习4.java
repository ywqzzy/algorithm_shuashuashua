import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 小仓的射击练习4 {
     public static class Point implements Comparable<Point>{
        double p;
        double a;
        int idx;
        Double profit;

        Point(int idx) {
            this.idx = idx;
        }
        @Override
        public int compareTo(Point o) {
            return (this.profit.compareTo(o.profit));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point []points = new Point[n];
        for(int i = 0; i < n; i++) points[i] = new Point(i+1);
        for(int i = 0; i < n; i++) points[i].p = sc.nextDouble();
        for(int i = 0; i < n; i++) points[i].a = sc.nextDouble();
        for(int i = 0; i < n; i++) points[i].profit = (points[i].p * points[i].a )/ (i + 1);

        Arrays.sort(points, Collections.reverseOrder());

        double res = 0;
        double factor = 1;
        while(n > 0) {
            for(int i = 0; i < n; i++) {
                if(n >= points[i].idx) {
                    n -= points[i].idx;
                    res +=  points[i].profit * factor;
                    factor *= points[i].p;
                    break;
                }
            }
        }
        System.out.printf("%.2f\n", res);
     }

//    int main()
//    {
//        int n;
//        cin >> n;
//        vector<double> p(n+1);
//        vector<int> a(n+1);
//        for (int i = 1; i <= n; i++)
//            cin >> p[i];
//        for (int i = 1; i <= n; i++)
//            cin >> a[i];
//        vector<double> dp(n+1);
//        dp[0] = 0;
//        for (int i = 1; i <= n; i++)
//        {
//            dp[i] = p[i] * a[i];
//        }
//        for(int i=1;i<=n;i++)
//            for (int j = 1; j <= i; j++)
//            {
//                dp[i] = max(p[j] * (a[j]+dp[i-j]),dp[i]);
//            }
//        printf("%.2f", dp[n]);
//    }
}
