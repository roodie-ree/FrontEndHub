module.exports = {
  extends: 'es/2015/client',
  parser: 'babel-eslint',
  parserOptions: {
    'sourceType': 'module'
  },
  plugins: [
    'react-hooks',
  ],
  rules: {
    'dot-location': [
      'error',
      'property'
    ],
    'linebreak-style': [
      'error',
      'unix'
    ],
    semi: [
      'error',
      'never'
    ],
    'comma-dangle': [
      'error',
      'always-multiline',
    ],
    'react-hooks/rules-of-hooks': 'error',
    'react-hooks/exhaustive-deps': 'error',
  }
}
