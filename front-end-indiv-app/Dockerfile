FROM node:lts-alpine3.14

WORKDIR /front-end-indiv-app

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "start"]