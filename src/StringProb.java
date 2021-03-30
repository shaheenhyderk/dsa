import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringProb {
    public static boolean isBalanced(String str) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        List<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (openingBrackets.indexOf(letter) != -1) {
                stack.add(letter);
            } else if (closingBrackets.indexOf(letter) != -1) {
                if (stack.size() == 0) {
                    return false;
                } else if (stack.get(stack.size() - 1) == matchingBrackets.get(letter)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> characterCounts = new HashMap<>();

        for (int idx = 0; idx < characters.length(); idx++){
            char character = characters.charAt(idx);
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }

        for (int idx=0; idx < document.length(); idx++){
            char character = document.charAt(idx);
            if (!characterCounts.containsKey(character) || characterCounts.get(character) == 0){
                return false;
            }
            characterCounts.replace(character, characterCounts.get(character) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "ashan";
        String document = "ahsan";
        System.out.println(generateDocument(characters, document));
    }
}
