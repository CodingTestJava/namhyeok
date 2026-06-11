package codingtestbook.first.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution12_2 {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            // 마지막 index는 무조건 stack에 남으니 n - 1 - j를 해도 됨.
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}