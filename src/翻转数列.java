import java.util.Scanner;

public class 翻转数列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        // 方差 2*m
        // 正数部分
        int start = 1+m;
        int startLst = 2*m;
        int end1 = n-m+1;
        int nums = n/(2*m);
        long totalPostive = 0;
        int t = 0;
        for(int i = start;i<=startLst;i++,t++) {
            long sum = (long)nums *(long)(i+ end1+t)/2;
            totalPostive += sum;
        }
//        System.out.println(totalPostive);
        // 负数部分
        int startNeg = 1;
        int startNeglast = m;
        int endNeg1 = n-2*m + 1;
        long totalNeg = 0;
        t = 0;
        for(int i = startNeg;i<=startNeglast;i++,t++) {
            long sum = (long)nums *(long)(i + endNeg1 + t)/2;
            totalNeg += sum;
        }
        System.out.println(totalPostive-totalNeg);
    }
}
