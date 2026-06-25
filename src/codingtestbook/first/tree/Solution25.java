package codingtestbook.first.tree;

public class Solution25 {

    // Binary Tree(이진 트리)에서 전위, 중위, 후위 순회를 구현하는 문제
    private String[] solution(int[] nodes) {
        // 배열을 받았는데 이를 이진 트리 구조로 변환시켜야 하나...?

        return null;
    }

    // 순회 방법에 따라 재귀 함수 호출 시점(방문 처리 시점)이 달라지기 때문에 각각의 함수로 구현

    // 전위 순회 함수 -> 부모, 왼쪽 자식, 오르쪽 자식 순
    private void pre() {
        // 현재 노드 방문 처리
        // 왼쪽 자식 호출
        // 오른쪽 자식 호출

    }

    // 중위 순회 함수 -> 왼쪽 자식, 부모, 오른쪽 자식 순
    private void in() {
        // 왼쪽 자식 호출
        // 현재 노드 방문 처리
        // 오른쪽 자식 호출
    }

    // 후위 순회 함수 -> 왼쪽 자식, 오른쪽 자식, 부모 순
    private void post() {
        // 왼쪽 자식 호출
        // 오른쪽 자식 호출
        // 현재 노드 방문 처리
    }
}
