package codingtestbook.first.array;

import java.util.Arrays;

public class Solution06_3 {

    public int[] solution(int N, int[] stages) {
        // 실패율 저장
        // index == stage 번호
        double[] failRates = new double[N + 1];

        // 각 스테이지 도전자 수 저장
        int[] challengers = new int[N + 2];

        // 스테이지 번호 저장
        Integer[] stageNumbers = new Integer[N];

        // 스테이지 번호 초기화
        for (int i = 0; i < N; i++) {
            stageNumbers[i] = i + 1;
        }

        // 각 스테이지 인원 수 카운트
        for (int stage : stages) {
            challengers[stage]++;
        }

        // 현재 스테이지 도달 인원
        int total = stages.length;

        // 실패율 계산
        for (int stage = 1; stage <= N; stage++) {
            // 도달 인원이 있는 경우만 계산
            if (total != 0) failRates[stage] = (double) challengers[stage] / total;

            // 다음 스테이지 도달 인원 갱신
            total -= challengers[stage];
        }

        // 실패율 기준 정렬
        Arrays.sort(stageNumbers, (a, b) -> {
            // 실패율이 같으면 작은 번호 우선
            if (failRates[a] == failRates[b]) {
                return a - b;
            }
            // 실패율 내림차순
            return Double.compare(
                    failRates[b],
                    failRates[a]
            );
        });

        // Integer[] -> int[]
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = stageNumbers[i];
        }

        return answer;
    }
}