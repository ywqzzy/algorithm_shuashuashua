package arr;

public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int cur = 0, cnt = 0;
        for(int num: nums) {
            if(cnt == 0) cur = num;
            if(num == cur) cnt++;
            else cnt--;
        }
        return cur;
    }
}
