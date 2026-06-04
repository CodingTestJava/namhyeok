package codingtestbook.array;

import java.util.Arrays;

public class Problem01 {

    /**
     * <h2>정렬(Sorting)</h2>
     *
     * <h3>정렬 메서드</h3>
     * <ul>
     *     <li>Arrays.sort()</li>
     *     <li>Collections.sort()</li>
     * </ul>
     *
     * <h3>사용 알고리즘</h3>
     * <table border="1">
     *     <tr>
     *         <th>메서드</th>
     *         <th>알고리즘</th>
     *         <th>Stable</th>
     *     </tr>
     *     <tr>
     *         <td>Collections.sort(List)</td>
     *         <td>TimSort</td>
     *         <td>O</td>
     *     </tr>
     *     <tr>
     *         <td>List.sort()</td>
     *         <td>TimSort</td>
     *         <td>O</td>
     *     </tr>
     *     <tr>
     *         <td>Arrays.sort(Object[])</td>
     *         <td>TimSort</td>
     *         <td>O</td>
     *     </tr>
     *     <tr>
     *         <td>Arrays.sort(int[])</td>
     *         <td>Dual-Pivot QuickSort</td>
     *         <td>X</td>
     *     </tr>
     *     <tr>
     *         <td>Arrays.sort(long[])</td>
     *         <td>Dual-Pivot QuickSort</td>
     *         <td>X</td>
     *     </tr>
     *     <tr>
     *         <td>Arrays.sort(double[])</td>
     *         <td>Dual-Pivot QuickSort</td>
     *         <td>X</td>
     *     </tr>
     * </table>
     *
     * <h3>TimSort vs Dual-Pivot QuickSort</h3>
     * <ul>
     *     <li>
     *         <b>TimSort</b>
     *         <ul>
     *             <li>이미 정렬된 구간(run)을 활용</li>
     *             <li>안정 정렬(Stable Sort)</li>
     *             <li>주로 객체(Object) 정렬에 사용</li>
     *         </ul>
     *     </li>
     *     <li>
     *         <b>Dual-Pivot QuickSort</b>
     *         <ul>
     *             <li>두 개의 Pivot을 사용하는 QuickSort</li>
     *             <li>불안정 정렬(Unstable Sort)</li>
     *             <li>주로 기본형(primitive) 정렬에 사용</li>
     *         </ul>
     *     </li>
     * </ul>
     *
     * <h3>안정 정렬(Stable Sort)</h3>
     * <p>
     * 동일한 정렬 키를 가진 원소의 상대적 순서를 유지하는 정렬
     * </p>
     *
     * <pre>
     * 정렬 전
     * (5, A), (3, X), (5, B)
     *
     * Stable 정렬 후
     * (3, X), (5, A), (5, B)
     *
     * Unstable 정렬 후
     * (3, X), (5, B), (5, A)
     * </pre>
     *
     * <h3>참고</h3>
     * <p>
     * Arrays.sort(int[]) 등의 primitive 배열은 Stable Sort가 보장되지 않지만
     * 동일한 값끼리는 식별자가 없으므로 실질적인 의미는 거의 없다.
     * </p>
     *
     * <pre>
     * [5, 3, 5, 1]
     * </pre>
     */
    public static void solution(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
