package codingtestbook.first.stack;

public class Solution14 {

    /*
     * 20시 15분 시작
     *
     * <문제 요구사항>
     * 명령어 기반 표의 행을 선택, 삭제, 복구하는 프로그램
     *
     * 삭제되지 않은 행은 O, 삭제된 행은 X로 표시하여 문자열 반환
     *
     *  각각의 기능들을 메서드로 만들고
     *  처음 버전과 최종 버전을 비교하면 될 듯.
     *
     */
    public String solution(int n, int k, String[] cmd) {
        // LinkedList를 직접 구현하면 될 것 같은데..? 아니면, Map으로 하던가...
        // 표는 Map<Integer, String> -> (index, name) 이렇게 하면 되고 -> 아 근데 표는 그냥 예시구나
        // 삭제된 행인지 아닌지 구분하기 위해 Map<Integer, Boolean> 이렇게 하면 될 듯 -> (index, isDeleted)
        // 삭제된 행의 index를 stack에 넣으면 될 듯


        String answer = "";
        return answer;
    }

    // 각각의 메서드는 요구사항에 맞게 구현
    // up 메서드

    // down 메서드

    // cancel 메서드

    // rollback 메서드
}
