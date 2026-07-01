package codingtestbook.first.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 모든 그래프의 노드를 탐색하는 문제
 *
 * @return dfs 순서로 노드가 저장된 리스트
 */
public class Solution34_1 {
    List<List<Integer>> graphList;
    boolean[] visited;
    List<Integer> answer;

    public List<Integer> solution(int[][] graph, int start, int n) {
        // graph 초기화
        graphList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graphList.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        answer = new ArrayList<>();

        // graph를 인접 리스트로 변환
        for (int[] arr : graph) {
            graphList.get(arr[0]).add(arr[1]);
            graphList.get(arr[1]).add(arr[0]);
        }

        // dfs 진행하면서 순서대로 노드 저장
        dfs(start);
        return answer;
    }

    // dfs 함수
    private void dfs(int cur) {
        visited[cur] = true;
        answer.add(cur);

        for (int next : graphList.get(cur)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
