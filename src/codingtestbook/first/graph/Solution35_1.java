package codingtestbook.first.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution35_1 {
    List<List<Integer>> graphList;
    boolean[] visited;
    List<Integer> answer;

    private List<Integer> solution(int[][] graph, int start, int n) {
        // 인접리스트 초기화
        graphList = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
            graphList.add(new ArrayList<>());
        }

        // graph를 인접리스트로 변환
        for (int[] arr : graph) {
            graphList.get(arr[0]).add(arr[1]);
            graphList.get(arr[1]).add(arr[0]);
        }
        visited = new boolean[n + 1];
        answer = new ArrayList<>();

        dfs(start);

        return answer;
    }

    private void dfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graphList.get(cur)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

    }
}
