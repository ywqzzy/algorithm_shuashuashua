package bit_operation;

public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        while(b != 0) {
            int plus = (a^b);
            b = ((a & b)<<1);
            a = plus;
        }
        return a;
    }
}
