package codingtestbook.first.array;

public class Solution05_2 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {

                for (int k = 0; k < c1; k++) { // 행렬의 곱에서 + 연산은 첫 번째 행렬의 열 개수(== 두 번쨰 행렬의 행 개수)만큼 수행
                    // 첫 번째 행렬의 i번째 행과 두 번째 행렬의 j번째  열을 곱셈
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}