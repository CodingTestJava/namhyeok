package codingtestbook.first.stack;

class Solution08_3 {
    boolean solution(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;

            } else {
                if (count == 0) {
                    return false;
                }

                count--;
            }
        }

        return count == 0;
    }
}
