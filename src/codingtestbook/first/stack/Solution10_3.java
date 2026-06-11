package codingtestbook.first.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution10_3 {
    public int solution(String s) {
        int n = s.length();
        s += s;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(s, i, n)) answer++;

        }
        return answer;
    }

    private boolean isValid(String s, int start, int n) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = start; i < start + n; i++) {
            char c = s.charAt(i);

            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');

            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
