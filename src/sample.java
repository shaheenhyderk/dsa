import java.util.HashMap;
import java.util.Map;

public class sample {
    public static void main(String[] args) {
        String input = "AABBBCCCCDEEEAA";
        countAndPrintCharacters(input);
    }

    private static void countAndPrintCharacters(String input) {
        char prev = 0;
        int count = 1;
        String pattern = "";
        for (int i = 0; i < input.length(); i++) {
            if (i == 0) {
                prev = input.charAt(i);
            } else {
                if (input.charAt(i) == prev) {
                    count++;
                } else {
                    pattern = pattern+prev+count;
                    prev = input.charAt(i);
                    count = 1;
                }
            }
        }
        pattern = pattern+prev+count;
        System.out.println(pattern);
    }

}
