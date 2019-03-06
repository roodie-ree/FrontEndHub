import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProblemSolver {
  public int solve(String input) throws IllegalArgumentException {
    String[] parts = input.split("(?<=\\d)\\s");
    Pattern calc = Pattern.compile("([^\\d-]+)(-?\\d+)");
    int result = 0;
    for (String part : parts) {
      int operand;
      String operator;
      try {
        Matcher match = calc.matcher(part);
        match.matches();
        operand = Integer.parseInt(match.group(2));
        operator = match.group(1);
      }
      catch (Exception e) {
        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
      }
        if (operator.contains("plus") || operator.contains("What is")) {
          result += operand;
        } else if (operator.contains("minus")) {
          result -= operand;
        } else if (operator.contains("multiplied")) {
          result *= operand;
        } else if (operator.contains("divided")) {
          result /= operand;
        }
    }
    return result;
  }
}
