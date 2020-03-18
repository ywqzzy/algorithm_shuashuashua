import java.util.ArrayList;
import java.util.Scanner;

public class 万万没想到之抓捕孔连顺 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,d;
        long res = 0;
        ArrayList<Integer> pos = new ArrayList<Integer>();
        n = sc.nextInt();
        d = sc.nextInt();
        for(int i=0;i<n;i++) pos.add(sc.nextInt());
        for(int i = 0;i<n;i++) {
            int start = i;
            int end = n-1;
            while(start <= end) {
                int mid = start + (end-start)/2;
                if(pos.get(mid) - pos.get(i) > d) {
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
            end = end<0?-1:end;
            //System.out.println("end:"+end);
            if((end-i)>=2) {
              //  System.out.println(end-i);
                res = (res + (long)(end-i-1)*(end-i)/2)%99997867;
                //System.out.println("res:"+res);
            }
        }
        System.out.println(res);
    }
}
