package codingtestbook.first.array;

import java.util.HashMap;
import java.util.Map;

public class Solution06_4 {

    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자 수
        int[] challengers = new int[N + 2];
        for (int stage : stages) {
            challengers[stage]++;
        }

        // 2. 스테이지별 실패한 사용자 수 및 실패율 계산을 위한 세팅
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 3. 각 스테이지를 순회하며 실패율 계산
        for (int i = 1; i <= N; i++) {
            // 도전한 사람이 없는 경우 실패율은 0
            if (challengers[i] == 0) fails.put(i, 0.0);

            else {
                // 실패율 계산
                fails.put(i, challengers[i] / total);
                // 다음 스테이지의 실패율을 구하기 위해 현재 스테이지 인원 제외
                total -= challengers[i];
            }
        }

        // 4. 실패율이 높은 스테이지부터 내림차순 정렬 (실패율이 같으면 스테이지 번호 낮은 순으로 정렬)
        return fails.entrySet().stream().sorted((o1, o2) ->
                    o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) : Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}