package codingtestbook.second.hash;

import java.util.HashSet;
import java.util.Set;

public class Solution18_1 {

    private boolean solution(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(target - arr[i])) {
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }
}
