all services running on docker using docker compose

logger present in Playerservice
---- used in --> /playerService/src/main/java/com/stackroute/playerservice/controller

zuul routing routes on :
---- :7788 for player service
---- :7789 for user service

Zuul gateway running on " https " !! run on a browser, doesn't run on postman !

Eureka configured for userservice and Player service ONLY

Config server properties present on github : https://github.com/Farhaan900/config-server-repo



Ports used for all the services :-

>> userService   :7788
>> playerService :7789
>> configServer  :8891
>> zuulGateway   :8000
>> eureka Server :9090
>> mongo server  :27017