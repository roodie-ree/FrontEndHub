import java.lang.IllegalArgumentException;

class PhoneNumber {
  private String cleaned;
  private static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
  private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage = "Can only have 11 digits if number starts with '1'";
  private static String illegalCharacterExceptionMessage = "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";
  private static String illegalAreaOrExchangeCodeMessage = "Illegal Area Or Exchange Code. Only 2-9 are valid digits";

  public PhoneNumber(String input) {
    cleaned = input.replaceAll("[\\(\\)\\.\\+\\- ]", "");
    if (cleaned.length() == 11 && cleaned.charAt(0) != '1') {
      throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
    }
    cleaned = cleaned.replaceAll("^1", "");
        if (cleaned.matches(".*\\D.*")) {
      throw new IllegalArgumentException(illegalCharacterExceptionMessage);
    }
    if (cleaned.length() != 10) {
      throw new IllegalArgumentException(wrongLengthExceptionMessage);
    }
    if (!cleaned.matches("1?[2-9]\\d{2}[2-9]\\d{6}")) {
      throw new IllegalArgumentException(illegalAreaOrExchangeCodeMessage);
    }
  }

  public String getNumber() {
    return cleaned;
  }
}
