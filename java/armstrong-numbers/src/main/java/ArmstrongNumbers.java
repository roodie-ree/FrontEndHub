/**
 * ArmstrongNumbers2
 */
public class ArmstrongNumbers {

  public boolean isArmstrongNumber(int number) {
    char[] digits = String.valueOf(number).toCharArray();
    int sum = 0;
    for (int i = 0; i < digits.length; i += 1) {
      double current = Character.getNumericValue(digits[i]);
      sum += (int) Math.pow(current, digits.length);
    }
    return number == sum;
  }
}
