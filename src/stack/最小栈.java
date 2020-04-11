package stack;

import java.util.Stack;

public class 最小栈 {

    // 前缀和的思想
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(!minStack.isEmpty()) {
                int t = minStack.peek();
                if(x <= t) minStack.push(x);
            } else minStack.push(x);
        }

        public void pop() {
            int t = stack.pop();
            int mt = minStack.peek();
            if(t == mt) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


}
