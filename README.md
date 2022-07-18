# Simple calculator microservice

## Run application

You can run this application using the command
```
./mvnw spring-boot:run
```
In windows:
```
mvnw.cmd spring-boot:run
```
## Build application

You can also compile and generate the jar using the command

In Unix:

```
./mvnw package
```
In windows:
```
mvnw.cmd package
```
This generates a jar in target that you can also run:
```
mvnw.cmd package
cd target
java -jar calculator-0.0.1-SNAPSHOT.jar
```

## Test service

To add two numbers (1+66):
```
 curl http://localhost:8080/binary-operation/1/ADD/66
```
To subtract two numbers (10-5):
```
 curl http://localhost:8080/binary-operation/10/SUBTRACT/5
```