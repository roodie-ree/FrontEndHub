function isIsogram(word) {
  const letters = word.replace(/[- ]/, '').toLowerCase()
  const set = new Set(letters)
  return letters.length === set.size
}

export { isIsogram }
