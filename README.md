# Calculator API

## This application contains two REST API's
  1. Calculator API
  2. Scientific Calculator API

## This application REST API's support these operations
  1. Calculator API supports addition, substraction,multiplication,division
  2. Scientific Calculator API supports factorial,square and isPrime

## Building the application

###  Generating jar file

1. You should have Java 8 and Maven already installed in the system
2. Run mvn clean install in the directory of api
3. api-0.0.1-SNAPSHOT.jar will be created in target folder
4. java -jar api-0.0.1-SNAPSHOT.jar will start the server in the port 8585
5. Now you should be able to access the application by http://localhost:8585


### Running Docker Containers

1. Back  end Docker build : 'docker build -t api:version1 .'
2. Important : Please do not forget the dot in the command
3. Running Spring :   'docker run -d  -p 8585:8585   8015967e4b5e'
4. Numericals are docker image id

