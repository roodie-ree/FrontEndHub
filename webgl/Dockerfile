FROM node:10.15.3-alpine AS build
WORKDIR /app
COPY .npmrc ./
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.15.12-alpine
COPY --from=build /app/dist /usr/share/nginx/html
