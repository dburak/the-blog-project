FROM node:18.8.0-alpine3.15

WORKDIR /app

COPY package.json package-lock.json ./

RUN npm install


COPY . .

EXPOSE 3000


CMD [ "npx", "serve", "-s", "build" ]