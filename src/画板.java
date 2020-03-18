import java.util.Scanner;

//水
public class 画板 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0) {
            long res = 0;
            int n = sc.nextInt();
            for(int i = 0;i<n;i++) {
                int x1,y1,x2,y2;
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                x2 = sc.nextInt();
                y2 = sc.nextInt();
                res += (y2-y1+1)*(x2-x1+1);
            }
            System.out.println(res);
        }

    }
}
