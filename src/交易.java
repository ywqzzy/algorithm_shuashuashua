import java.util.Scanner;

public class 交易 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int sum = 0;
            for(int i = 0;i<5;i++)sum+=sc.nextInt();
            if(sum == 0) System.out.println(-1);
            else if(sum % 5 == 0) System.out.println(sum/5);
            else System.out.println(-1);
        }
    }
}
