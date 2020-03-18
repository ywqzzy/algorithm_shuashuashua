import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 等差数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(sc.nextInt());
        Collections.sort(list);
        int d = list.get(1)-list.get(0);
        for (int i = 2;i<n;i++) {
            if(list.get(i) - list.get(i-1) != d) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");

    }
}
