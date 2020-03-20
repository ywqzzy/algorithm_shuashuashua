package linkedlist;

public class 寻找重复数 {

    // 循环检测 可以把题目转换成环形链表入口那题。。。。 太难了！！！
    public int findDuplicate(int []nums) {
        if(nums.length <= 1) return -1;
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
