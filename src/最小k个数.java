import java.util.*;

public class 最小k个数 {
    public static int[] smallestK(int []arr, int k) {
        int []res = new int[k];
        if(k == 0) return res;
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < arr.length; i++) {
            if(pqMax.size() < k) pqMax.add(arr[i]);
            else if(pqMax.peek() > arr[i]) {
                pqMax.poll();
                pqMax.add(arr[i]);
            }
        }
        int i = k -1;
        while(pqMax.isEmpty() == false) {
            res[i--] = pqMax.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int []arr = {1,3,5,7,2,4,6,8};
        int[]res = smallestK(arr,4);
        for(int i = 0; i < res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
