import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 糖果谜题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> mmap = new HashMap<>();
        int sum=0;
        while(sc.hasNext()) {
            int t = sc.nextInt();
            if(mmap.containsKey(t)) {
                mmap.put(t, mmap.get(t)+1);
            }else {
                mmap.put(t,1);
            }
        }
        //System.out.println("????");
        for(Map.Entry<Integer,Integer> entry: mmap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == key+1) {
                sum+=value;
            }else if(value > key+1) {
                sum+= (value+key)/(key+1) * (key+1) ;// 2 7  现在是错的
            }else if(value < key+1) {
                sum+=key+1;
            }
        }
        System.out.println(sum);
    }

}
