import java.util.ArrayList;
import java.util.Scanner;

public class 小易的升级之路 {
    static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), a = sc.nextInt();
            ArrayList<Integer> bs = new ArrayList<>();
            for (int i = 0; i < n; i++) bs.add(sc.nextInt());
            long res = 0;
            for (int i = 0; i < n; i++) {
                if (a >= bs.get(i)) {
                    a += bs.get(i);
                } else {
                    a += gcd(a, bs.get(i));
                }
            }
            System.out.println(a);
        }
    }
}
