function keep<T>(list: T[], predicate: (item: T) => boolean): T[] {
  return list.filter(predicate)
}

function discard<T>(list: T[], predicate: (item: T) => boolean): T[] {
  return list.filter((item) => !predicate(item))
}

export { keep, discard }
