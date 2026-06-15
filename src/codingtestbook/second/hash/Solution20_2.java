package codingtestbook.second.hash;

import java.util.HashMap;
import java.util.Map;

public class Solution20_2 {

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wishList = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }

        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String , Integer> discountList = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountList.put(discount[j], discountList.getOrDefault(discount[j], 0) + 1);
            }

            if (wishList.equals(discountList)) answer++;
        }

        return answer;
    }
}
