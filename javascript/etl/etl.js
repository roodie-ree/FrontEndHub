import _ from 'lodash'

function transform(oldScrable) {
  return _.transform(oldScrable, (result, value, key) => {
    value.forEach(letter => {
      result[letter.toLowerCase()] = Number.parseInt(key, 10)
    })
  })
}

export { transform }
