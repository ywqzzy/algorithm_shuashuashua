import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// how come? I am silly bee.
public class 有趣的排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++) list.add(sc.nextInt());
        Collections.sort(list);



    }
}
