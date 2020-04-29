FROM node:10-alpine as builder
WORKDIR '/app'
COPY ./package.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:alpine
ENV TZ Europe/Warsaw
RUN ln -s /usr/share/zoneinfo/Europe/Warsaw /etc/localtime ;\
    echo $TZ > /etc/timezone

EXPOSE 80
COPY nginx.conf /etc/nginx/nginx.conf

WORKDIR /usr/share/nginx/html
COPY --from=builder /app/dist .
