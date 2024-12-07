FROM node:alpine

WORKDIR /usr/app

COPY ./ ./
RUN npm install
RUN npm run autoCreate

CMD ["npm", "run", "dev"]