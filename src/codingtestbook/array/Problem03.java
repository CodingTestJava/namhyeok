package codingtestbook.array;

import java.util.*;

class Problem03 {

    /**
     * answer를 오름차순으로 반환하라고 했기 때문에 TreeSet을 사용했지만,
     * 보통 HashSet을 사용하고 마지막에 정렬을 하는 것이 더 빠른 경우가 많음.
     * 삽입의 시간 복잡도가 O(1)이고 정렬은 마지막에 한 번만 하면 되기 때문.
     *
     * TreeSet은 삽입 때마다 정렬이 수행되어서 데이터가 많을 때는 비효율적임.
     *
     */
    public int[] solution(int[] numbers) {
        int k = numbers.length;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++){
                set.add(numbers[i] + numbers[j]);
            }

        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

