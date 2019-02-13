import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

  private List<Long> series;
  LargestSeriesProductCalculator(String inputNumber) {
    if (!inputNumber.matches("^\\d*$")) {
      throw new IllegalArgumentException("String to search may only contain digits.");
    }
    series = inputNumber.chars()
      .mapToLong(digit -> Character.getNumericValue((char)digit))
      .boxed()
      .collect(Collectors.toList());
  }

  long calculateLargestProductForSeriesLength(int numberOfDigits) {
    if (numberOfDigits < 0) {
      throw new IllegalArgumentException("Series length must be non-negative.");
    }
    if (numberOfDigits > series.size()) {
      throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
    }
    if (numberOfDigits == 0) {
      return 1;
    }
    return IntStream.rangeClosed(0, series.size() - numberOfDigits)
      .mapToLong(index -> series.subList(index, index + numberOfDigits)
        .stream()
        .reduce(1l, (a, b) -> a * b))
      .max()
      .getAsLong();
  }
}
