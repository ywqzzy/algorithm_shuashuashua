package stack;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
    class MyStack {

        private Queue<Integer> mq;

        /** Initialize your data structure here. */
        public MyStack() {
            mq = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            mq.add(x);
            int size = mq.size();
            while(size > 1) {
                mq.add(mq.remove());
                size--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return mq.remove();
        }

        /** Get the top element. */
        public int top() {
            return mq.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return mq.isEmpty();
        }
    }

}
