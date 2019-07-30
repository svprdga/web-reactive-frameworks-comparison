# Web Reactive Frameworks Comparison

The objective of this project is to develop a minimal rest service in order to compare the speed and eficiency of each framework.

The requirements for the test are as follows:
* The API must expose a GET /galaxies endpoint which will retrieve a list of galaxies form a PostgreSQL database.
* The access to the database must be via an ORM.

## Preparation

Create the database and populate its data using the setup_queries.sql file.

## Launch examples

### Run aqueduct:
* Install the aqueduct tool: https://aqueduct.io/
* `cd aqueduct`
* `pub get`
* `aqueduct serve`

### Run ktor-exposed:
* `cd ktor-exposed`
* `./gradlew run`

### Run node-express-sequelize:
* `cd node-express-sequelize`
* `npm i`
* `npm run build`
* `npm run start`

### Run spring-boot
* `cd spring-boot`
* `./gradlew bootRun`

### Run vertx-ktorm
* Install vertx tool: https://vertx.io/download/
* `cd vertx-ktorm`

### Run vertx-spring
* Install vertx tool: https://vertx.io/download/
* `cd vertx-spring`
