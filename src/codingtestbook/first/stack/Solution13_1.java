package codingtestbook.first.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution13_1 {

    public int solution(int[][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            for (int r = 0; r < board.length; r++) {
                if (board[r][moves[i] - 1] == 0) continue;

                if (!stack.isEmpty() && stack.peek() == board[r][moves[i] - 1]) {
                    stack.pop();
                    answer += 2;

                } else {
                    stack.push(board[r][moves[i] - 1]);
                }

                board[r][moves[i] - 1] = 0;
                break;
            }

        }


        return answer;
    }
}
