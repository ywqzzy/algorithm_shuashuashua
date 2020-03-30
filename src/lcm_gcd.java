import java.util.Scanner;

public class lcm_gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(n*(n-1) - 1);
        }
    }
}
