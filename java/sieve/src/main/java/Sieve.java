import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {
  private Integer max;

  Sieve(int maxPrime) {
    max = maxPrime;
  }

  List<Integer> getPrimes() {
    boolean[] isPrime = new boolean[max + 1];
    Arrays.fill(isPrime, true);
    Integer bound = (int)(Math.ceil(Math.sqrt(max.doubleValue())));
    for (Integer f_1 = 2; f_1 < bound; f_1 += 1) {
      if (!isPrime[f_1]) {
        continue;
      }
      for (Integer f_2 = 2; f_2 < max; f_2 += 1) {
        try {
          isPrime[f_1 * f_2] = false;
        } catch (IndexOutOfBoundsException ex) {
          break;
        }
      }
    }
    return IntStream.rangeClosed(2, max)
      .filter(number -> isPrime[number])
      .boxed()
      .collect(Collectors.toList());
  }
}
