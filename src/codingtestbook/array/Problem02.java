package codingtestbook.array;

import java.util.*;

public class Problem02 {

    private int[] solution(int[] arr) {
        // Set으로 중복 제거
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // 내림차순 정렬
        List<Integer> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());

        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
