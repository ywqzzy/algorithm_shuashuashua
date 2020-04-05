package design;

import java.util.Collections;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    class MedianFinder {
        PriorityQueue<Integer> maxHeap, minHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) * 0.5;
            }
            return maxHeap.peek();
        }
    }

}
