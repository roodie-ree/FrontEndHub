import java.util.stream.IntStream;

class LuhnValidator {

  boolean isValid(String candidate) {
    String check = candidate.replaceAll(" ", "");
    if (!check.matches("\\d{2,}")) {
      return false;
    }
    int sum = IntStream.range(0,check.length())
      .map(index -> {
        int value = Character.getNumericValue(check.charAt(index));
        // do not double the check (last) digit
        if (check.length() % 2 == 0) {
          // double even indices if the length is even
          return index % 2 == 0 ? value * 2 : value;
        }
        return index % 2 == 0 ? value : value * 2;
      })
      .map(value -> value > 9 ? value -9 : value)
      .sum();
    return sum % 10 == 0;
  }

}
