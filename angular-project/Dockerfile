FROM node:carbon

WORKDIR /app

COPY . .

RUN npm install 

RUN npm install http-server -g

RUN npm run build 

WORKDIR /app/dist/goldys-gym-admin

CMD ["http-server", "-c1", "-p", "80"]
