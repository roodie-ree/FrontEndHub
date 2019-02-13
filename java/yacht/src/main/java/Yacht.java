import java.util.HashMap;
import java.util.OptionalInt;

class Yacht {

    private HashMap<Integer, Integer> dice;
    private YachtCategory category;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        category = yachtCategory;
        this.dice = new HashMap<Integer, Integer>();
        for (int die : dice) {
            if (this.dice.containsKey(die)) {
                this.dice.put(die, this.dice.get(die) + 1);
            } else {
                this.dice.put(die, 1);
            }
        }
    }

    int score() {
        switch (category) {
        case ONES:
            return numberOfSame(1);
        case TWOS:
            return numberOfSame(2);
        case THREES:
            return numberOfSame(3);
        case FOURS:
            return numberOfSame(4);
        case FIVES:
            return numberOfSame(5);
        case SIXES:
            return numberOfSame(6);
        case FULL_HOUSE:
            return fullHouse();
        case FOUR_OF_A_KIND:
            return fourOfAKind();
        case LITTLE_STRAIGHT:
        case BIG_STRAIGHT:
            return straight();
        case CHOICE:
            return choice();
        case YACHT:
            return yacht();
        default:
            return 0;
        }
    }

    int sumOfAllDice() {
        int sum = 0;
        return dice.entrySet().stream()
            .mapToInt(die -> die.getKey() * die.getValue())
            .sum();
    }

    int numberOfSame(int die) {
        return die * dice.getOrDefault(die, 0);
    }

    int fullHouse() {
        if (dice.size() != 2 || !dice.values().contains(3)) {
            return 0;
        }
        return sumOfAllDice();
    }

    int fourOfAKind() {
        OptionalInt fourDice = dice.entrySet().stream()
            .filter(die -> die.getValue() >= 4)
            .mapToInt(die -> die.getKey())
            .findFirst();
        return fourDice.orElse(0) * 4;
    }

    int straight() {
        if (dice.size() == 5) {
            if (!dice.containsKey(6) && category == YachtCategory.LITTLE_STRAIGHT) {
                return 30;
            }
            if (!dice.containsKey(1) && category == YachtCategory.BIG_STRAIGHT) {
                return 30;
            }
        }
        return 0;
    }

    int choice() {
        return sumOfAllDice();
    }

    int yacht() {
        if (dice.size() == 1) {
            return 50;
        }
        return 0;
    }
}
