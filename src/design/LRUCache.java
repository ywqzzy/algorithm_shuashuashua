package design;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key) == false) return -1;
        Integer res = map.remove(key);
        map.put(key, res);
        return res;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if(map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
