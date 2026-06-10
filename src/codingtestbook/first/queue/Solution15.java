package codingtestbook.first.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 아래 풀이의 시간복잡도는 O(N*K)이지만,
 * 세그먼트 트리라는 자료구조를 사용하면 O(NlogN)까지 줄일 수 있다고 함.....
 */
public class Solution15 {

    private int solution(int N, int K) {
        // 큐에 1~N까지 숫자 세팅
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 1~K-1까지는 dequeue해서 enqueue, K번째는 dequeue만
        // 한개가 남을 때까지 반복
        while (queue.size() > 1) {
            for (int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        // 마지막 큐에 있는 것 dequeue 후 반환
        return queue.poll();
    }
}
