public class Encryptor {
    public static String encryptor(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            int newLetterCode = str.charAt(i) + newKey;
            newLetters[i] = newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
        }
        return new String(newLetters);
    }

    public static void main(String[] args) {
        String str = "aya";
        String result = encryptor(str, 2);
        System.out.println(result);
    }
}