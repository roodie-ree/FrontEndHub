const http = require('http');
const createExpress = require('./create-express');

const app = createExpress();
const server = http.createServer(app);
const port = 5678;

server.listen(port, () => {
  console.log(`listening on http://localhost:${port}`);
});
