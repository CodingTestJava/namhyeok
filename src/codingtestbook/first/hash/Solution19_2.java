package codingtestbook.first.hash;

/**
 * 첫번째 풀이에서는 HashSet을 사용했지만, 이러면 중복 처리를 해결할 수 없음.
 * 따라서 HashMap을 사용해서 해결
 */
import java.util.*;

// 22시 47분 시작
class Solution19_2 {
    public String solution(String[] participant, String[] completion) {
        // for문 2개는 시간초과라서 for문 내부에서 HashTable을 사용해서 O(1)로 접근해야 함

        Map<String, Integer> map = new HashMap<>();
        for (String str : completion) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String str : participant) {
            int count = map.getOrDefault(str, 0);
            if (count == 0) return str;

            map.put(str, count - 1);

        }
        return null;
    }
}
