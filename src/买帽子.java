import java.util.*;

public class 买帽子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> s = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i=0;i<n;i++) {
            int t = sc.nextInt();
            s.add(t);
        }
        if(s.size()<3) System.out.println(-1);
        else {
            List<Integer> list = new ArrayList<>(s);
            System.out.println(list.get(2));
        }
    }
}
