package codingtestbook.first.hash;

import java.util.HashSet;
import java.util.Set;

public class Solution18_2 {

    private boolean solution(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(target - arr[i])) return true;

            set.add(arr[i]);
        }

        return false;
    }

}
