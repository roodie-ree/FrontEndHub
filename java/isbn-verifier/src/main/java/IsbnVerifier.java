class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String check = stringToVerify.replaceAll("[^0-9X]", "");
        if (!check.matches("^[0-9]{9}[0-9X]$")) {
            return false;
        }
        char[] isbn = check.toCharArray();
        int sum = 0;
        for (int i = 0; i < 10; i += 1) {
            if (isbn[i] == 'X') {
                sum += 10;
            } else {
                sum += Character.getNumericValue(isbn[i]) * (10 - i);
            }
        }
        return sum % 11 == 0;
    }

}
