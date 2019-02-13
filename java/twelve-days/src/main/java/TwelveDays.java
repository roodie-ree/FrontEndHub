import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {
  private static final String start =
    "On the %s day of Christmas my true love gave to me: ";
  private static final String[] days = {
    "first",
    "second",
    "third",
    "fourth",
    "fifth",
    "sixth",
    "seventh",
    "eighth",
    "ninth",
    "tenth",
    "eleventh",
    "twelfth"
  };
  private static final String[] gifts = {
    "a Partridge in a Pear Tree",
    "two Turtle Doves",
    "three French Hens",
    "four Calling Birds",
    "five Gold Rings",
    "six Geese-a-Laying",
    "seven Swans-a-Swimming",
    "eight Maids-a-Milking",
    "nine Ladies Dancing",
    "ten Lords-a-Leaping",
    "eleven Pipers Piping",
    "twelve Drummers Drumming"
  };


  String verse(int verseNumber) {
    String begin = String.format(start, days[verseNumber - 1]);
    String giftsGiven = IntStream.range(0, verseNumber)
      .map(index -> verseNumber - 1 - index)
      .mapToObj(index -> gifts[index])
      .collect(Collectors.joining(", "))
      .replaceAll(",([^,]+)$", ", and$1");
    String result = begin + giftsGiven + ".\n";
    return result;
  }

  String verses(int startVerse, int endVerse) {
    return IntStream.rangeClosed(startVerse, endVerse)
      .mapToObj(this::verse)
      .collect(Collectors.joining("\n"));
  }

  String sing() {
    return verses(1, 12);
  }
}
