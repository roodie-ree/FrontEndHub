/**
 * Atbash
 */
public class Atbash {
  static String alphabet = "abcdefghijklmnopqrstuvwxyz";

  private void encodeChars(char[] input) {
    for (int index = 0; index < input.length; index += 1) {
      int charIndex = alphabet.indexOf(input[index]);
      if (charIndex != -1) {
        input[index] = alphabet.charAt(alphabet.length() - charIndex - 1);
      }
    }
  }

  String encode(String input) {
    char[] onlyLetters = input.toLowerCase().replaceAll("\\W", "").toCharArray();
    encodeChars(onlyLetters);
    String asString = new String(onlyLetters);
    String addSpaces = asString.replaceAll("(.{5})(?=.)", "$1 ");
    return addSpaces;
  }

  String decode(String input) {
    char[] onlyLetters = input.replaceAll(" ", "").toCharArray();
    encodeChars(onlyLetters);
    return new String(onlyLetters);
  }
}
