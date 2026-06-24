package codingtestbook.first.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution21_2 {
    public String[] solution(String[] record) {
        // 아이디어:
        // 유저 아이디, 닉네임을 Map에 저장
        Map<String, String> users = new HashMap<>();

        List<String[]> userActions = new ArrayList<>();

        for (String str : record) {
            String[] userInfo = str.split(" ");
            String action = userInfo[0];
            String userId = userInfo[1];

            // Enter, Change의 경우 유저 정보 저장 or 업데이트 (유저 아이디, 닉네임)
            if (!action.equals("Leave")) {
                String nickname = userInfo[2];
                users.put(userId, nickname);
            }

            // Enter, Leave만 action 저장
            if (!action.equals("Change")) {
                userActions.add(new String[]{action, userId});
            }

        }

        String[] answer = new String[userActions.size()];
        for (int i = 0; i < userActions.size(); i++) {
            String[] strArr = userActions.get(i);
            String action = strArr[0];
            String userId = strArr[1];

            String nickname = users.get(userId);

            if (action.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";

            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }


}
