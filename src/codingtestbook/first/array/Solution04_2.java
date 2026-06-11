package codingtestbook.first.array;

import java.util.*;

class Solution04_2 {

    public int[] solution(int[] answers) {
        // 각 수포자의 반복 패턴
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 각 수포자의 점수 저장
        int[] scores = new int[3];

        // 모든 문제 순회
        for (int i = 0; i < answers.length; i++) {

            // 각 수포자의 패턴과 비교
            for (int j = 0; j < patterns.length; j++) {

                // 정답과 패턴이 일치하면 점수 증가
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 최고 점수 찾기
        int max = Arrays.stream(scores)
                .max()
                .getAsInt();

        // 최고 점수를 받은 사람 번호 저장
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {

            // 최고 점수와 같으면 번호 추가
            if (scores[i] == max) {
                result.add(i + 1);
            }
        }

        // List<Integer> → int[] 변환 후 반환
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}