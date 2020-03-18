import java.util.Scanner;

public class 贪吃的小Q {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int tmax = 1;
        boolean flag = true;
        if(n == 1 ) {
            System.out.println(m);
        }else {
            while (flag == true) {
                int sum = 0;
                int tdays = 0;
                int t = tmax;
                while (t > 0) {
                    sum += t;
                    tdays++;
                    int tt = t;
                    t /= 2;
                    if (tt == 1) break;
                    if (tt % 2 != 0) t += 1;
                }
                sum += (n - tdays - 1);
                if (sum < m) tmax++;
                else {
                    tmax--;
                    flag = false;
                }
            }
            System.out.println(tmax);
        }
    }
}
