package codingtestbook.second.hash;

import java.util.Arrays;

public class Solution18_2 {

    private boolean solution(int[] arr, int target) {
        int front = 0;
        int rear = arr.length - 1;

        Arrays.sort(arr);

        while (front < rear) {
            int cur = arr[front] + arr[rear];

            if (cur == target) return true;
            else if (cur < target) front++;
            else if (cur > target) rear--;
        }

        return false;
    }
}
