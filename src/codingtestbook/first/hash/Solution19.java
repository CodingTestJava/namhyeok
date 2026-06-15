package codingtestbook.first.hash;

import java.util.*;

// 22시 47분 시작
class Solution19 {
    public String solution(String[] participant, String[] completion) {
        // for문 2개는 시간초과라서 for문 내부에서 HashTable을 사용해서 O(1)로 접근해야 함

        // completion을 HashSet? HashMap?으로 변환
        HashSet<String> hashSet = new HashSet<>(List.of(completion));

        for (String str : participant) {
            if (hashSet.contains(str)) {
                continue;
            }

            return str;

        }
        return "";
    }
}
