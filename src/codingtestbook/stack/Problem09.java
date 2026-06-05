package codingtestbook.stack;

public class Problem09 {

    public static String solution(int decimal) {
        StringBuilder sb = new StringBuilder();

        while (decimal != 0) {
            int r = decimal % 2;
            sb.append(r);

            decimal = decimal / 2;
        }

        return sb.reverse().toString();
    }
}
