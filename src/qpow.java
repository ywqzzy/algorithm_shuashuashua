import java.util.Scanner;

public class qpow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int res = 1;
            a %= c;
            for (; b != 0; b /= 2) {
                if (b % 2 == 1)
                    res = (res * a) % c;
                a = (a * a) % c;
            }
            System.out.println(res);
        }
    }
}