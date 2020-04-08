package 蓄水池抽样;

import java.util.Random;

public class 随机数索引 {
    class Solution {

        private final int[] data;

        public Solution(int[] nums) {
            data = nums;
        }

        public int pick(int target) {
            int cnt = 0;
            int current = -1;
            Random r = new Random();
            for(int i = 0; i < data.length; i++) {
                if(data[i] == target) {
                    cnt++;
                    if(r.nextInt() % cnt == 0) current = i;
                }
            }
            return current;
        }
    }
}
