import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class 雀魂启动 {
    public static boolean check(int addNum, ArrayList<Integer> list) {
        list.add(addNum);
        Collections.sort(list);
        int len = list.size();
        int i = 0;
        int cnt = 0;
        int top = 0;
        while(i+2<=len) {
            if(i+2<len) {
                if (list.get(i + 2) == list.get(i) && list.get(i + 1) == list.get(i)) {
                    i += 3;
                    cnt++;
                } else if (list.get(i + 1) == list.get(i) && list.get(i + 1) != list.get(i + 2)) {
                    i += 2;
                    top++;
                } else if (list.get(i + 1) == list.get(i) + 1 && list.get(i + 2) == list.get(i + 1) + 1) {
                    i += 3;
                    cnt++;
                }else if(list.get(i) == list.get(i+2) ){

                }
            }else {
                if(i+2==len) {
                    if (list.get(i + 1) == list.get(i)) top++;
                    break;
                }else return false;
            }
        }
        if(top == 1 && cnt == 4) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < 13;i++) list.add(sc.nextInt());
        for (int i = 1;i<10;i++) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int num:list) {
                t.add(num);
            }
            if(check(i,t)== true) {
                System.out.println(i);
                break;
            }
        }
    }
}
