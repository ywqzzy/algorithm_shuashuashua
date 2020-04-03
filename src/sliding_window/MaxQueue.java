package sliding_window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    Queue<Integer> q;
    Deque<Integer> dq;
    public MaxQueue() {
        q = new LinkedList<>();
        dq = new LinkedList<>();
    }

    public int max_value() {
        if(dq.size() > 0) return dq.peek();
        else return -1;
    }

    public void push_back(int value) {
        q.offer(value);
        while(dq.size() > 0 && dq.peekLast() < value) {
            dq.pollLast();
        }
        dq.offerLast(value);
    }

    public int pop_front() {
        int temp = q.size()>0 ? q.poll():-1;
        if(dq.size()>0 && temp == dq.peek()) dq.poll();
        return temp;
    }

}
