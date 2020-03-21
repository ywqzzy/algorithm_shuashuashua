package dp;

public class fib {
    public int fib(int n) {
        int a = 0, b=1,temp;
        for(int i = 0; i < n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return a;
    }
}
