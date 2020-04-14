package 单调栈_队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 柱状图中最大的矩形 {
    // 单调栈 查找每个数左侧第一个比它小（大）的数
    // 单调队列 查找滑动窗口中的最值
    public int largestRectangleArea(int[] heights) {
        // 枚举所有上边界，作为整个矩形的上边界，并且求出左右边界
        // 1. 找出左边离他最近的，比他小的柱形
        // 2. 找出右边离他最近的，比他小的柱形
        int len = heights.length;
        System.out.println();
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(stack.empty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(stack.empty()) {
                right[i] = len;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int res = 0;
        for(int i = 0; i < len; i++) res = Math.max(res, heights[i] * (right[i] - left[i] - 1));

        return res;
    }
}
