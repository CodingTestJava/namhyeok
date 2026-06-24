package codingtestbook.first.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 11시 50분 시작
class Solution23_2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 내가 신고한 사람과 그 사람의 신고 당한 횟수를 알아야 함.
        int n = id_list.length;
        Map<String, Integer> userInfoMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            userInfoMap.put(id_list[i], i);
        }

        // 신고 처리 - 동일 사람에 대해 중복 신고 불가
        // 신고 당한 사람에 대한 정보를 저장하기 위한 map 생성
        Map<String, Node> map = new HashMap<>();

        // 신고 처리
        for (String str : report) {
            String[] arr = str.split(" ");
            String reporter = arr[0];
            String user = arr[1];

            Node node = map.computeIfAbsent(user, key -> new Node());
            node.report(reporter);
        }

        // Node 중에서 reportCount가 k 이상인 것들을 찾고
        // set에 있는 이름의 index에 ++
        int[] answer = new int[n];

        for (Map.Entry<String, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            if (node.reportCount < k) continue;

            for (String reporter : node.reporterList) {
                answer[userInfoMap.get(reporter)]++;
            }

        }

        return answer;
    }

    static class Node {
        int reportCount = 0;
        Set<String> reporterList = new HashSet<>();

        void report(String reporter) {
            if (reporterList.add(reporter)) reportCount++;
        }

    }
}