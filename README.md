# FizzBuzz

### to run the project :
sudo docker-compose build --build-arg profile="dev"
sudo docker-compose up

### test Apis:

curl --location --request POST 'http://localhost:8080/fizzbuzz' \
--header 'Content-Type: application/json' \
--data-raw '{
"param1": 3,
"param2": 7,
"limit": 100,
"str1": "Fizz",
"str2": "Buzz"
}'

curl --location --request GET 'http://localhost:8080/fizzbuzz/frequent'


### architecture :
hexagonal architecture with 3 maven modules : application, domain and infrastructure

### infrastructure :
liquibase for initiating db and tracking changes 
init script under application/resources/static/scripts
in memory H2 database for dev only 

### profiles : 
two profiles dev and prod 
dev run on port 8080 and uses an in memory H2 database for tracking the frequent FizzBuzz
prod expect to get the parameters (server port, db credentials, etc...) from environment variables 

### build :
docker multistage build with profile as param


