package heap;

import java.util.*;

public class 前k个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a,b)->a.getValue().equals(b.getValue())?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue()
        );

        for (Map.Entry<String,Integer> entry:map.entrySet()){
            maxHeap.offer(entry);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }

        }
        while (!maxHeap.isEmpty()){
            res.add(0,maxHeap.poll().getKey());
        }
        return res;
    }
}
