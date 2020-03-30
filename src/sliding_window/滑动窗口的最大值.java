package sliding_window;


import java.util.LinkedList;

public class 滑动窗口的最大值 {
    // hard
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k) return new int[0];
        int index = 0;
        int[]res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            while(!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]) qMax.pollLast();
            qMax.addLast(i);
            if(qMax.peekFirst() == (i - k)) qMax.pollFirst();
            if(i >= k - 1) {
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;
    }
}
