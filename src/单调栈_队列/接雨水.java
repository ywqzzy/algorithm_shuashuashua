package 单调栈_队列;

import java.util.Stack;

public class 接雨水 {
    // 单调递减栈  一层一层算面积
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            int last = 0;
            while(!stk.isEmpty() && height[stk.peek()] <= height[i]) {
                int t = stk.peek();
                stk.pop();
                res += (i - t - 1) * (height[t] - last);
                last = height[t];
            }
            if(!stk.isEmpty()) res += (i - stk.peek() - 1) * (height[i] - last);
            stk.push(i);
        }
        return res;
    }
}
