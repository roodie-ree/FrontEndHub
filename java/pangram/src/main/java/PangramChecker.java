public class PangramChecker {
  private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

  public boolean isPangram(String input) {
    String pangram = input.toLowerCase();
    for (char letter : alphabet) {
      if (pangram.indexOf(letter) == -1) {
        return false;
      }
    }
    return true;
  }

}
