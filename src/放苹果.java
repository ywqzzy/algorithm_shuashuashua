import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class 放苹果 {
    static  ArrayList<Integer>[] list = null;
    static  Boolean[] flag = null;
    static int res = 0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine())+100;
        int ai = Integer.valueOf(sc.nextLine());
        int m = Integer.valueOf(sc.nextLine());
        flag = new Boolean[n];
        list = new ArrayList[n];
        for(int p = 0;p < n;p++){
            list[p] = new ArrayList<Integer>();
        }
        for(int i = 0;i < m;i++){

            String str = sc.nextLine();
            String[] split = str.split(",");
            int a = Integer.valueOf(split[0]);
            int b = Integer.valueOf(split[1]);
            list[a].add(b);
            list[b].add(a);
        }

        flag[ai] = true;

        List<Integer>list1 = list[ai];
        int len = list1.size();
        for(int k = 0;k < len;k++) {
            int tmp1 = list[ai].get(k);
            flag[tmp1] = true;
        }
        for(int t = 0;t < len;t++){
            int tmp1 = list[ai].get(t);
            calculate(tmp1);
        }
        System.out.println(res);
    }


    public static void calculate(int tmp){
        List<Integer>list2 = list[tmp];
        int len = list2.size();
        for(int i = 0;i < len;i++){
            int tmp2 = list2.get(i);
            if(flag[tmp2] == false){
                res++;
                flag[tmp2] = true;
                calculate(tmp2);
            }
        }
    }
}
