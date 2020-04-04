package design;

import java.util.Stack;

public class 用两个栈实现队列 {
    class CQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if(!s2.empty()) return s2.pop();
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.isEmpty() ? -1 : s2.pop();
        }
    }
}
