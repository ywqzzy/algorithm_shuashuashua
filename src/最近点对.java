import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 最近点对 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[]array = new Node[n];
        for(int i = 0;i < n;i++){
            Node t = new Node();
            t.setX(sc.nextInt());
            t.setY(sc.nextInt());
            array[i] = t;
        }
        Arrays.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        System.out.println(helper(array,0,n));
    }
    public static class Node{
        int x,y;
        public Node() {
            x = 0;
            y = 0;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY(){
            return y;
        }
    }
    static double maxResult = Double.MAX_VALUE;
    public static double helper(Node[]array,int start,int end){
        int mid,i,j,tail = 0;
        Node []br = new Node[array.length];
        double d;
        if(start == end) return maxResult;
        mid = (start + end) / 2;
        d = Math.min(helper(array,start,mid),helper(array,mid + 1,end));
        for(i = mid;i >= start && array[mid].x - array[i].x < d;i--){
            br[tail++] = array[i];
        }
        for(i = mid + 1;i < end && array[i].x - array[mid].x < d;i++){
            br[tail++] = array[i];
        }
        Arrays.sort(br, 0, tail, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.y - o2.y;
            }
        });
        for(i = 0;i < tail;i++){
            for(j = i + 1;j < tail && br[j].y - br[i].y < d;j++){
                if(d > dis(br[i],br[j])){
                    d = Math.min(d,dis(br[i],br[j]));
                }
            }
        }
        return d;
    }
    public static double dis(Node a,Node b){
        double x = (a.x - b.x) * (a.x - b.x);
        double y = (a.y - b.y) * (a.y - b.y);
        return Math.sqrt(x + y);
    }

}
