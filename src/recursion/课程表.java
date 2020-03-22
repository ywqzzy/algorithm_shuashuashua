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
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for(int[] p: prerequisites) {
            adjacency.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adjacency, visited, i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] visited, int i) {
        if(visited[i] == 1) return  false;
        if(visited[i] == -1) return true;
        visited[i] = 1;
        for(int j = 0; j < adjacency.get(i).size(); j++) {
            if(!dfs(adjacency, visited, adjacency.get(i).get(j))) return false;
        }
        visited[i] = -1;
        return true;
    }


}
