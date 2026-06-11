package codingtestbook.first.array;

import java.util.ArrayList;
import java.util.List;

public class Solution06_2 {
// 문제 해석
// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
// 즉, stages에 담긴 stage의 수(A) / stages에 담긴 stage 중 A 보다 크거나 같은 수의 합

    // N+1? 아 마지막 스테이지까지 클리어한 사용자. ㅇㅋ.
    public List<Integer> solution(int N, int[] stages) {
        double[] failRates = new double[N];
        int[] challengers = new int[N + 2];

        // 각 스테이지 인원 수 저장
        for (int stage : stages) {
            challengers[stage]++;
        }

        // 실패율 계산
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            if (total != 0) failRates[i - 1] = (double) challengers[i] / total;

            total -= challengers[i];
        }

        // 결과 저장
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double max = -1;
            int index = -1;

            // 최대 실패율 찾기
            for (int j = 0; j < N; j++) {
                if (failRates[j] > max) {
                    max = failRates[j];
                    index = j;
                }
            }

            answer.add(index + 1);

            // 사용 처리
            failRates[index] = -1;
        }

        return answer;
    }
}
