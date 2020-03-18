import java.util.Scanner;

public class 找零 {
    public static void main(String[] args) {
        int []a={1,4,16,64};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),cnt=0;
        n=1024-n;
        while(n>0) {
            for(int i=3;i>=0;i--) {
                if((n-a[i])>=0) {
                    n-=a[i];
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
