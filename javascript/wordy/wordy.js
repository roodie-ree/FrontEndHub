class ArgumentError extends Error {}

const operators = {
  What: (a, b) => a + b,
  plus: (a, b) => a + b,
  minus: (a, b) => a - b,
  multiplied: (a, b) => a * b,
  divided: (a, b) => a / b,
}

function calculateStep(result, step) {
  const operation = step.match(/\s*(\w+)[^-\d]+(-?\d+)/)
  if (operation === null) {
    throw new ArgumentError()
  }
  const operator = operators[operation[1]]
  const operand = Number.parseInt(operation[2], 10)
  if (typeof operator !== 'function' || Number.isNaN(operand)) {
    throw new ArgumentError()
  }
  return operator(result, operand)
}

class WordProblem {
  constructor(problem) {
    this.problem = problem
  }

  answer() {
    const steps = this.problem.split(/(?<=\d)\s/)
    return steps.reduce(calculateStep, 0)
  }
}

export { ArgumentError, WordProblem }
