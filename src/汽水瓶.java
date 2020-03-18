import java.util.Scanner;

public class 汽水瓶 {
    public static int cal(int n) {
        if(n==2) return 1;
        if(n==3) return 1;
        if(n>3) return cal(n%3+n/3) + n/3;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n==0) break;
            System.out.println(cal(n));
        }
    }
}
