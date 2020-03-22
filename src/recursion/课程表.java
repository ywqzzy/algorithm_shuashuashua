package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 课程表 {


    // 1. bfs   toposort
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for(int[] p: prerequisites) {
            indegree[p[0]] ++;
            adjacency.get(p[1]).add(p[0]);
        }
        for(int i = 0; i < numCourses; i++) if(indegree[i] == 0) queue.add(i);
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur: adjacency.get(pre)) {
                if(--indegree[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }

    // 2. dfs 判断图中是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return false;
    }


}
