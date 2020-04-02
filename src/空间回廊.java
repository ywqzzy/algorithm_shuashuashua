import java.util.Scanner;

public class 空间回廊 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []cost = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) cost[i] = sc.nextInt();
        int idx = 0;
        boolean flag = false;
        int missCnt = 0;
        while(m > 0) {
            if(m >= cost[idx]) {
                res++;
                m -= cost[idx];
                idx ++;
                if(idx == n) idx = 0;
            } else {
                if(flag == true) {
                    missCnt++;
                    if(missCnt == n) break;
                } else {
                    flag = false;
                    missCnt = 1;
                }
                idx ++;
            }
        }
        System.out.println(res);
    }
}
