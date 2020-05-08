# Obtain self signed certificate for Nginx and then keystore for Java server app 
`sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/nginx-selfsigned.key -out /etc/ssl/certs/nginx-selfsigned.crt`  
`sudo openssl dhparam -out /etc/ssl/certs/dhparam.pem 2048`  
keystore password will have to be provided after executing command:  
`openssl pkcs12 -export -in nginx/nginx-selfsigned.crt -inkey nginx/nginx-selfsigned.key -out keystore.p12`  
