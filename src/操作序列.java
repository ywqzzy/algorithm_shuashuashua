import java.util.*;

public class 操作序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            if(i % 2==0) {
                 q.offerLast(sc.nextInt());
            }else {
                 q.offerFirst(sc.nextInt());
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(q.size()>0){
            list.add(q.pop());
        }
        if(n%2!=0) {
            // last -->first
            for(int i = list.size()-1;i>=0;i--) {
                System.out.print(list.get(i));
                if(i!=0) System.out.print(" ");
            }
        }else {
            for(int i = 0;i<list.size();i++) {
                System.out.print(list.get(i));
                if(i!=list.size()-1) System.out.print(" ");
            }
        }
        System.out.println();
    }
}
