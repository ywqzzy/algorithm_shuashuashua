package bit_operation;

public class 数组中数字出现的次数II {
    // hash  too naive

    // 出现1次的 那么那个bit位肯定出现3*x + 1次
    // 时间复杂度O(n) 可优化
    public int singleNumber1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int cnt = 0;
            int idx = 1<<i;
            for(int num: nums) {
                if((idx & num) != 0) cnt++;
            }
            if(cnt % 3 == 1) res |= idx;
        }
        return res;
    }


    // TODO
    public int singleNumber(int[] nums) {
        return 0;
    }
}
