import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class WordCount {

  public Map<String, Integer> phrase(String sentence) {
    HashMap<String, Integer> count = new HashMap<>();
    String[] words = sentence.trim().split("[^'\\w]+");
    Arrays.stream(words)
      .map(String::toLowerCase)
      .map(word -> word.replaceAll("^\\W|\\W$", ""))
      .forEach(word -> {
        count.putIfAbsent(word, 0);
        count.put(word, count.get(word) + 1);
      });
    Stream.of(words)
      .collect(Collectors.toMap(keyMapper, valueMapper))
    return count;
  }
}
