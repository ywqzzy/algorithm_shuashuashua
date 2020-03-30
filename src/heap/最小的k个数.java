package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的k个数 {

    // 大顶堆  最好写的写法
    public int[] getLeastNumbers1(int[] arr, int k) {
        if(k == 0 || arr.length == 0) return new int[0];
        Queue<Integer> pq = new PriorityQueue<>((v1, v2)-> v2 - v1);
        for(int num: arr) {
            if(pq.size() < k) pq.offer(num);
            else if(num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

    // partion  最快的解法
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0) return new int[0];

        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSelect(int[] nums, int low, int high, int k) {
        int index = partition(nums, low, high, k);
        if(index == k) return Arrays.copyOf(nums, k+1);
        else if(index > k) return quickSelect(nums, low, index -1, k);
        else return quickSelect(nums, index + 1, high, k);
    }
    int partition(int[] nums, int low, int high, int k) {
        int pivot = nums[low];
        while(low < high) {
            while(low < high && nums[high] <= pivot) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] >= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
