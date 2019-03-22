const handshakes = new Map([
  [0b10000, 'reverse'],
  [0b1000, 'jump'],
  [0b100, 'close your eyes'],
  [0b10, 'double blink'],
  [0b1, 'wink'],
]);

function secretHandshake(input) {
  const num = typeof input === 'string'
    ? Number.parseInt(input, 10)
    : input;

  if (!Number.isInteger(num)) {
    throw new Error('Handshake must be a number');
  }
  if (num < 1 || num > 31) {
    throw new Error('Number must be between 1 and 31');
  }
  let leftover = num;
  const handshake = [];
  handshakes.forEach((action, code) => {
    if (leftover - code >= 0) {
      leftover -= code;
      handshake.push(action);
    }
  });
  if (handshake[0] === 'reverse') {
    handshake.shift();
  } else {
    handshake.reverse();
  }
  return handshake;
}

export { secretHandshake };
