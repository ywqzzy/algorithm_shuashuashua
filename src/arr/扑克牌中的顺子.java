package arr;

public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE,zeroCount = 0;
        int[] repeatNums = new int[15];

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            if (repeatNums[num]++ > 0) {
                return false;
            }
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min  + 1 <= 5;
    }
}
