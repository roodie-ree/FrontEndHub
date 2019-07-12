function robHouses(houses) {
  if (houses.length < 2) {
    return houses[0] || 0
  }

  const lastHouse = houses
    .slice(2)
    .reduce(([firstHouse, secondHouse], house) =>
      [secondHouse, Math.max(firstHouse + house, secondHouse)],
      [houses[0],Math.max(houses[0], houses[1])])
    .pop()

  return lastHouse
}

module.exports = robHouses

// const zeroStreet = []
// console.log(robHouses(zeroStreet))

// const oneStreet = [5]
// console.log(robHouses(oneStreet))

// const firstStreet = [5, 1, 1, 5]
// console.log(robHouses(firstStreet))

// const secondStreet = [5, 5, 1, 1]
// console.log(robHouses(secondStreet))

// const thirdStreet = [5, 1, 5, 1]
// console.log(robHouses(thirdStreet))

// const forthStreet = [1, 5, 5, 1]
// console.log(robHouses(forthStreet))

// const fifthStreet = [1, 5, 1, 5]
// console.log(robHouses(fifthStreet))
