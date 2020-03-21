package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1]: o2[0]-o1[0];
            }
        });

        List<int[]> out = new LinkedList<>();
        for(int i = 0; i < people.length; i++) out.add(people[i][1], people[i]);
        return out.toArray(new int[people.length][2]);
    }
}
