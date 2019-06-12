FROM node:10-alpine AS build
WORKDIR /app
COPY package.json .
RUN npm install
COPY src /app/src
RUN npm run test \
  && npm run build

FROM node:10-alpine
WORKDIR /app
COPY package.json .
RUN npm install --production
COPY --from=build /app/dist .
ENV PORT = 80
EXPOSE 80
CMD [ "node ./dist/app.js" ]
