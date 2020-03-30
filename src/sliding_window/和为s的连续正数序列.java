package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int start = 1;
        int end = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while(start <= target/2) {
            if(sum < target) {
                sum += end;
                end++;
            } else if(sum > target) {
                sum -= start;
                start++;
            } else {
                int[] arr = new int[end-start];
                for(int i = start; i < end; i++) {
                    arr[i - start] = i;
                }
                res.add(arr);
                sum -= start;
                start++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
