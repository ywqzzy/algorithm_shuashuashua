import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class 度度熊回家 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> pos = new ArrayList<>();
        for(int i = 0;i<n;i++) pos.add(sc.nextInt());
        int min = 0x3f3f3f3f;
        int tmpPos = pos.get(0);
        int temp = 0;
        for(int i = 1;i<n-1;i++) {
            temp = 0;
            tmpPos = pos.get(0);
            for(int j=1;j<n;j++) {
                if(j == i) {
                    continue;
                }
                int maxx = Math.max(pos.get(j), tmpPos);
                int minn = Math.min(pos.get(j), tmpPos);
                temp += maxx-minn;
                tmpPos = pos.get(j);
            }
            min = Math.min(min,temp);
        }
        System.out.println(min);
    }
}
