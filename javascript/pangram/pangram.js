const alphabet = 'abcdefghijklmnopqrstuvwxyz'.split('')

function isPangram(sentence) {
  const lower = sentence.toLowerCase()
  return alphabet.reduce((notFound, letter) =>
    notFound && lower.includes(letter))
}

export { isPangram }
