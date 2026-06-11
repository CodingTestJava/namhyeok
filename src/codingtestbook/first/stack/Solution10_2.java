package codingtestbook.first.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution10_2 {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (isValid(s)) answer++;

            s = rotate(s);
        }
        return answer;
    }

    private String rotate(String s) {
        return s.substring(1) + s.charAt(0);
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');

            else if (stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
