package codingtestbook.first.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution23_4 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵 (신고당한 유저, 해당 유저를 신고한 유저들)
        Map<String, Set<String>> reportedUserList = new HashMap<>();

        // 신고 처리
        for (String r : report) {
            String[] s = r.split(" ");
            String reporter = s[0];
            String reportedUser = s[1];

            // 신고당한 기록이 없다면 reportedUser에 추가
            reportedUserList.computeIfAbsent(reportedUser, key -> new HashSet<>());

            // 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUserList.get(reportedUser).add(reporter);
        }

        int[] answer = new int[id_list.length];

        Map<String, Integer> userInfoMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userInfoMap.put(id_list[i], i);
        }

        for (Map.Entry<String, Set<String>> entry : reportedUserList.entrySet()) {
            if (entry.getValue().size() < k) continue;

            for (String reporter : entry.getValue()) {
                answer[userInfoMap.get(reporter)]++;
            }
        }



        return answer;
    }
}