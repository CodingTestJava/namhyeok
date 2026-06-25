package codingtestbook.first.tree;

import java.util.Arrays;

public class Solution25_1 {
    StringBuilder[] sb;

    // Binary Tree(이진 트리)에서 전위, 중위, 후위 순회를 구현하는 문제
    private String[] solution(int[] nodes) {
        // 배열을 받았는데 이를 이진 트리 구조로 변환시켜야 하나...?
        sb = new StringBuilder[3];
        sb[0] = new StringBuilder();
        sb[1] = new StringBuilder();
        sb[2] = new StringBuilder();

        pre(nodes[0], nodes);
        in(nodes[0], nodes);
        post(nodes[0], nodes);

        return new String[]{sb[0].toString(), sb[1].toString(), sb[2].toString()};
    }

    // 순회 방법에 따라 재귀 함수 호출 시점(방문 처리 시점)이 달라지기 때문에 각각의 함수로 구현

    // 전위 순회 함수 -> 부모, 왼쪽 자식, 오르쪽 자식 순
    private void pre(int k, int[] nodes) {
        if (k >= nodes.length) return;

        // 현재 노드 방문 처리
        sb[0].append(nodes[k]).append(" ");

        // 왼쪽 자식 호출
        pre(2 * k + 1, nodes);

        // 오른쪽 자식 호출
        pre(2 * k + 2, nodes);

    }

    // 중위 순회 함수 -> 왼쪽 자식, 부모, 오른쪽 자식 순
    private void in(int k, int[] nodes) {
        if (k >= nodes.length) return;

        // 왼쪽 자식 호출
        in(2 * k + 1, nodes);

        // 현재 노드 방문 처리
        sb[1].append(nodes[k]).append(" ");

        // 오른쪽 자식 호출
        in(2 * k + 2, nodes);
    }

    // 후위 순회 함수 -> 왼쪽 자식, 오른쪽 자식, 부모 순
    private void post(int k, int[] nodes) {
        if (k >= nodes.length) return;

        // 왼쪽 자식 호출
        post(2 * k + 1, nodes);

        // 오른쪽 자식 호출
        post(2 * k + 2, nodes);

        // 현재 노드 방문 처리
        sb[2].append(nodes[k]).append(" ");

    }

}
