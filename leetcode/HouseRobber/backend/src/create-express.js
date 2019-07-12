const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser')
const robHouses = require('./robber')


function createExpress() {
  const app = express();
  app.use(cors());
  app.use(bodyParser.json())
  app.get('/newGame', (req, res) => {
    res.json({ game: [1, 2, 3, 4]})
  });
  app.post('/submitSolution', (req, res) => {
    const result = robHouses(req.body.houses)

    res.json({ correct: result === req.body.solution })
  });
  app.get('/highscore', (req, res) => {
    res.json({ user: 4, user2: 1 })
  });
  return app;
}

module.exports = createExpress;
