import java.util.Set;
import java.util.stream.Collectors;

class IsogramChecker {

  boolean isIsogram(String phrase) {
    String lower = phrase.toLowerCase().replaceAll("\\W", "");
    Set<Integer> letters = lower.chars()
      .boxed()
      .collect(Collectors.toSet());
    return lower.length() == letters.size();
  }

}
