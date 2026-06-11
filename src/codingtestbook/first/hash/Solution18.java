package codingtestbook.first.hash;

import java.util.Arrays;

public class Solution18 {

    private boolean solution(int[] arr, int target) {
        Arrays.sort(arr);
        int front = 0;
        int rear = arr.length - 1;

        while (front < rear) {
            int sum = arr[front] + arr[rear];

            if (sum == target) return true;
            else if (sum < target) front++;
            else if (sum > target) rear--;
        }

        return false;
    }

}
