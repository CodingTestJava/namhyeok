package codingtestbook.second.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution19_3 {

    public String solution(String[] participant, String[] completion) {
        // 동명이인이 있을 수 있기 때문에 해시테이블 사용
        // Map<String, Integer> -> (이름, 동명이인 수)
        Map<String, Integer> map = new HashMap<>();

        // 1. completion을 map에 저장.
        for (String str : completion) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // 2. participant가 있으면 1--
        // participant가 없으면 return key.
        // or participant를 key로 가지는 value가 0이면 return key. -> 완주자에는 count가 0인데, participant에 해당 이름이 있으면 완주하지 못한 것이기 때문
        for (String str : participant) {
            if (map.getOrDefault(str, 0) == 0) return str;
            map.put(str, map.get(str) - 1);
        }

        return null;
    }
}
