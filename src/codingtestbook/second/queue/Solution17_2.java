package codingtestbook.second.queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution17_2 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards1, 2를 각각의 스택에 넣어놓고
        Queue<String> queue1 = new ArrayDeque<>(List.of(cards1));
        Queue<String> queue2 = new ArrayDeque<>(List.of(cards2));

        // goal 배열을 돌면서 top이 있으면 pop, 없으면 return No
        for (String str : goal) {
            if (str.equals(queue1.peek())) {
                queue1.poll();

            } else if (str.equals(queue2.peek())) {
                queue2.poll();

            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
