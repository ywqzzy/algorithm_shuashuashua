import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class 纸牌游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(sc.nextInt());
        Collections.sort(list);
        long sum1=0;
        long sum2=0;
        int len=list.size();
        if(len%2==0) {
            for(int i=0;i<len;i+=2) sum1+=list.get(i);
            for(int i=1;i<len;i+=2) sum2+=list.get(i);
            System.out.println(sum2-sum1);
        }else {
            for(int i=0;i<len;i+=2) sum2+=list.get(i);
            for(int i=1;i<len;i+=2) sum1+=list.get(i);
            System.out.println(sum2-sum1);
        }
    }
}
