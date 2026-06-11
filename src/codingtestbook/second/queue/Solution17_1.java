package codingtestbook.second.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution17_1 {

    // ToDo: new ArrayDeque<>(List.of(cards)) 이렇게 했을 때 front와 rear의 pointer 확인!!!!
    // 실수로 스택으로 풀었는데 맞았음....
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards1, 2를 각각의 스택에 넣어놓고
        Deque<String> stack1 = new ArrayDeque<>(List.of(cards1));
        Deque<String> stack2 = new ArrayDeque<>(List.of(cards2));

        // goal 배열을 돌면서 top이 있으면 pop, 없으면 return No
        for (String str : goal) {
            if (str.equals(stack1.peek())) {
                stack1.pop();

            } else if (str.equals(stack2.peek())) {
                stack2.pop();

            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
