import express from 'express';
import cors from 'cors';
import { secretHandshake } from './secret-handshake';

function handleHandshake(req, res) {
  let handshake;
  try {
    const { number } = req.query;
    console.log(`Getting handshake ${number}`);
    handshake = secretHandshake(number);
  } catch (err) {
    console.log(err);
    res.sendStatus(400);
  }
  res.json(handshake);
}

function delay(req, res, next) {
  setTimeout(() => next(), 2000);
}

function createExpress() {
  const app = express();
  app.use(cors());
  app.use(delay);
  app.get('/handshake', handleHandshake);
  return app;
}

export default createExpress;
