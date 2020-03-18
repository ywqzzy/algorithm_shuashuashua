import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        for(int i = 1; i <= intervals.length; ) {
            int startRange = intervals[i-1][0];
            int endRange = intervals[i-1][1];
            int j = i;
            for(; j < intervals.length; j++) {
                if(intervals[j][0] < endRange) {
                    endRange = Math.max(intervals[j][1], endRange);
                } else {
                    break;
                }
            }
            i = j + 1;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(startRange);
            temp.add(endRange);
            res.add(temp);
        }
        int [][]resArr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            for(int j = 0; j < 2; j++) {
                resArr[i][j] = res.get(i).get(j);
            }
        }
        return resArr;
    }
}
