# Build and Install

## Frontend

```
yarn install
yarn build

cp -r build ../src/main/resources/public
```

## Backend

```
mvn clean install
java -jar spring-global-population-0.0.1-SNAPSHOT.jar
```
