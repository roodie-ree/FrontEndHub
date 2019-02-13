function validate(num) {
  const digits = num.toString();
  return digits.split('')
    .reduce((sum, digit) => sum + (parseInt(digit, 10) ** digits.length),
      0) === num;
}

export { validate };
