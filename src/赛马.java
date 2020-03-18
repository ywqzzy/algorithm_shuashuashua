import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 赛马 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n=sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<2*n;i++) list.add(sc.nextInt());
            Collections.sort(list);
            int sum1=0,sum2=1,sum3=1;
            int mid1=list.get(n-1);
            int mid2=list.get(n);
            int k = n+1;
            if(mid1!=mid2) {
                System.out.println("YES");continue;
            }else {
                System.out.println("NO");continue;
            }
        }
    }
}
