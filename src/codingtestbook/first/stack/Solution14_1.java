package codingtestbook.first.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution14_1 {

    public String solution(int n, int k, String[] cmd) {
        // LinkedList를 직접 구현하면 될 것 같은데..? 아니면, Map으로 하던가...

        // 표는 Map<Integer, String> -> (index, name) 이렇게 하면 되고 -> 아 근데 표는 그냥 예시구나
        // 삭제된 행인지 아닌지 구분하기 위해 Map<Integer, Boolean> 이렇게 하면 될 듯 -> (index, isDeleted)
        Map<Integer, Boolean> chart = new HashMap<>();
        for (int i = 0; i < n; i++) {
            chart.put(i, false);
        }

        // 삭제된 행의 index를 stack에 넣으면 될 듯
        Deque<Integer> stack = new ArrayDeque<>();

        int pointer = k;

        for (String str : cmd) {
            if (str.startsWith("U")) {
                String[] strArr = str.split(" ");
                pointer = up(pointer, Integer.parseInt(strArr[1]), chart);

            } else if (str.startsWith("D")) {
                String[] strArr = str.split(" ");
                pointer = down(pointer, Integer.parseInt(strArr[1]), chart);

            } else if (str.startsWith("C")) {
                pointer = cancel(pointer, chart, stack, n);

            } else {
                rollback(chart, stack);

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(chart.get(i) ? "X" : "O");
        }

        return sb.toString();
    }

    // 각각의 메서드는 요구사항에 맞게 구현
    // up 메서드
    private int up(int pointer, int offset, Map<Integer, Boolean> chart) {
        int moved = 0;

        while (moved < offset) {
            pointer--;

            if (!chart.get(pointer)) moved++;

        }

        return pointer;
    }

    // down 메서드
    private int down(int pointer, int offset, Map<Integer, Boolean> chart) {
        int moved = 0;

        while (moved < offset) {
            pointer++;
            if (!chart.get(pointer)) moved++;

        }

        return pointer;
    }

    // cancel 메서드
    private int cancel(int pointer, Map<Integer, Boolean> chart, Deque<Integer> stack, int n) {
        // 삭제 처리
        chart.put(pointer, true);
        stack.push(pointer);

        // 아래 행 찾기
        int next = pointer + 1;

        while (next < n) {
            if (!chart.get(next)) {
                return next;
            }
            next++;
        }

        // 아래 행 없으면 위 행 찾기
        int prev = pointer - 1;

        while (prev >= 0) {
            if (!chart.get(prev)) {
                return prev;
            }
            prev--;
        }

        return -1;
    }

    // rollback 메서드
    private void rollback(Map<Integer, Boolean> chart, Deque<Integer> stack) {
        int pop = stack.pop();
        chart.put(pop, false);
    }

}
