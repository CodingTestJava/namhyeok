package codingtestbook.second.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution19 {

    public String solution(String[] participant, String[] completion) {
        // 동명이인이 있을 수 있기 때문에 해시테이블 사용
        // Map<String, Integer> -> (이름, 동명이인 수)
        Map<String, Integer> map = new HashMap<>();

        // 1. participant Map에 저장. O(N)
        for (String str : participant) {
        }

        // 2. completion 찾으면 -1. O(N)
        for (String str : completion) {
        }

        // 3. count 수가 0이 아닌 놈이 완주하지 못한 선수 O(N)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

        }

        String answer = "";
        return answer;
    }
}
