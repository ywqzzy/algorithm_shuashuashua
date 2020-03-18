import java.util.*;

public class 按出现次数排序 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i < t;i++) {
            int m = sc.nextInt(), n = sc.nextInt();
            int[]array1 = new int[m];
            int[]array2 = new int[n];
            for(int j = 0;j < m;j++) array1[j] = sc.nextInt();
            for(int j = 0;j < n;j++) array2[j] = sc.nextInt();
            int[] result = new int[m];
            result = sort(array1, array2);
            for(int p = 0; p < result.length - 1; p++)
                System.out.print(result[p]+" ");
            System.out.println(result[result.length - 1]);
        }
    }
    public static int[] sort(int[]array1,int[]array2){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array1.length; i++) {
            if(!map.containsKey(array1[i])) map.put(array1[i],1);
            else map.put(array1[i],map.get(array1[i])+1);
        }
        for(int i = 0; i < array2.length; i++) {
            if (map.containsKey(array2[i])) {
                int tmp = map.get(array2[i]);
                for (int j = 0; j < tmp; j++) list.add(array2[i]);
            }
        }
        Map<Integer, Integer>map2 = new HashMap<>();
        for(int i = 0;i < array2.length;i++){
            if(!map2.containsKey(array2[i])) map2.put(array2[i], 1);
            else map2.put(array2[i],map2.get(array2[i]) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (!map2.containsKey(key) )
                for(int i = 0;i < value;i++) list.add(key);
        }
        int[]result = new int[list.size()];
        for(int i = 0;i < list.size();i++) result[i] = list.get(i);
        return result;
    }
}
