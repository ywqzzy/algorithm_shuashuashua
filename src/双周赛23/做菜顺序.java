package 双周赛23;

import java.util.Arrays;

public class 做菜顺序 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int mx = 0;
        for(int i = 0; i < satisfaction.length; i++) {
            int temp = 0;
            int time = 1;
            for(int j = i; j < satisfaction.length; j++) {
                temp += satisfaction[j] * time;
                time++;
            }
            mx = Math.max(mx, temp);
        }
        return mx;

    }
}
