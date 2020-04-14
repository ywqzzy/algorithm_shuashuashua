package graph;

import java.util.Arrays;

public class 网络延迟时间 {
    // 1. dijkstra
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        for(int[] edge: times) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        int[] distance = new int[N + 1];
        Arrays.fill(distance, - 1);
        for(int i = 1; i <= N; i++) distance[i] = graph[K][i];
        distance[K] = 0;
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        for(int i = 1; i < N; i++) {
            int minDis = Integer.MAX_VALUE;
            int minIdx = 1;
            for(int j = 1; j <= N; j++) {
                if(!visited[j] && distance[j] != -1 && distance[j] < minDis) {
                    minDis = distance[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;

            for(int j = 1; j <= N; j++) {
                if(graph[minIdx][j] != -1) {
                    if(distance[j] != -1) {
                        distance[j] = Math.min(distance[j], distance[minIdx] + graph[minIdx][j]);
                    } else {
                        distance[j] = distance[minIdx] + graph[minIdx][j];
                    }
                }
            }
        }
        int maxDis = 0;
        for(int i = 1; i <= N; i++) {
            if(distance[i] == -1) return -1;
            maxDis = Math.max(distance[i], maxDis);
        }
        return maxDis;
    }
    // 2. floyd

    // 3. bellman-ford
}
