import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 完全没有思路可还行
public class 派对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int r,g,b;
            r=sc.nextInt();g=sc.nextInt();b=sc.nextInt();
            int min = Math.min(Math.min(r,g),b);
            int max = Math.max(Math.max(r,g),b);
            int mid=0, res = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(r);list.add(g);list.add(b);
            Collections.sort(list);
            mid = list.get(1);
            if((mid+min)*2 < max) {
                res = min+mid;
            }else {
                res = (min+max+mid)/3;
            }
            System.out.println(res);
        }
    }
}
