import http from 'http';
import createExpress from './create-express';

const app = createExpress();
const server = http.createServer(app);
const port = 1234;

server.listen(port, () => {
  console.log(`listening on http://localhost:${port}`);
});
