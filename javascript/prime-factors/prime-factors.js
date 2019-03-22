function primeFactors(num) {
  let leftover = num;
  let divisor = 2;
  const factors = [];
  while (leftover > 1) {
    if (leftover % divisor === 0) {
      leftover /= divisor;
      factors.push(divisor);
    } else {
      divisor += 1;
    }
  }
  return factors;
}

export { primeFactors };
