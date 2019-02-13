class ArmstrongNumbers {

  boolean isArmstrongNumber(int numberToCheck) {
    String digits = Integer.toString(numberToCheck);
    int sum = digits.chars()
      .map(c -> Character.getNumericValue((char) c))
      .map(digit -> (int) Math.pow(digit, digits.length()))
      .sum();
    return sum == numberToCheck;
  }

}
