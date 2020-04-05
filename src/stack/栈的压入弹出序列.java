package stack;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushSize = pushed.length;
        int popSize = popped.length;
        if(popSize != pushSize) return false;
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        for(int i = 0; i < pushSize; i++) {
            s.push(pushed[i]);
            while(!s.empty() && idx < popSize && popped[idx] == s.peek()) {
                idx++;
                s.pop();
            }
        }
        return s.empty();
    }
}
