# Web Reactive Frameworks Comparison

The objective of this project is to develop a REST API using different technologies in order to be able to compare them by getting some performance metrics.

The requirements for the test are as follows:
* The API must expose a *GET /galaxies* operation which will retrieve a list of galaxies form a PostgreSQL database.
* Lots of projects in real life use some kind of database library to access the data instead of performing raw SQL queries, as this type of tools affects the performance of the application, each project must implement one of them.

If you think that I am missing something to the take the best of each technology, pull requests are welcome.

## Technologies under test

### [Aqueduct](https://aqueduct.io/)
* Description: _An object-oriented, multi-threaded HTTP server framework written in Dart._
* Language: Dart
* Database lib: ORM included in the framework.

### [Ktor](https://ktor.io/)
* Description: _Ktor is a framework for building asynchronous servers and clients in connected systems using the powerful Kotlin programming language._
* Language: Kotlin
* Database lib: _[Exposed](https://github.com/JetBrains/Exposed) is a prototype for a lightweight SQL library written over JDBC driver for Kotlin language._

### [Express](https://expressjs.com/)
* Description: _Fast, unopinionated, minimalist web framework for Node.js_
* Language: Typescript
* Database lib: _[Sequelize](https://sequelize.org/) is a promise-based Node.js ORM for Postgres, MySQL, MariaDB, SQLite and Microsoft SQL Server. _

### [Spring Boot](https://spring.io/projects/spring-boot)
* Description: _Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run"._
* Language: Kotlin
* Database lib: [Hibernate](http://hibernate.org/) is probably the most famous ORM in the Java world.

### [Vert.x](http://vertx.io/) ~ [Ktorm](http://vertx.io/)
* Description: _Eclipse Vert.x is a tool-kit for building reactive applications on the JVM._
* Language: Kotlin
* Database lib: _[Ktorm](http://vertx.io/) is a lightweight and efficient ORM Framework for Kotlin directly based on pure JDBC._

### [Vert.x](http://vertx.io/) ~ [Spring Boot](https://spring.io/projects/spring-boot)
* Description: Combines the asynchronous features of Vert.x with the Spring Boot platform.
* Language: Kotlin
* Database lib: [Hibernate](http://hibernate.org/) is probably the most famous ORM in the Java world.

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
* `cd vertx-ktorm`
* `./gradlew run`

### Run vertx-spring
* `cd vertx-spring`
* `./gradlew run`

## Test results

* Tests were driven in a laptop with a i7-8750H CPU, SDRAM DDR4-2666, NVMe hard drive.
* The benchmark tool used is [Artillery](https://artillery.io/).
* The test consist in simulate 2000 users, each one performing 50 requests.

The values measured are:
* min: Minimal latency in milliseconds.
* max: Maximum latency in milliseconds.
* median: Arithmetic average of the latency, in milliseconds.
* p95: 95th percentile value.
* p99: 99th percentile value.

### Aqueduct:
* The server start good but stop responding after a while, tests for this server were canceled.

### Ktor-Exposed:
* min: 0.4
* max: 122
* median: 5.8
* p95: 12.1
* p99: 21

### Node-Express-Sequelize
* min: 0.4
* max: 93
* median: 1.6
* p95: 7
* p99: 9.4

### Spring-Boot
* min: 0.3
* max: 101.8
* median: 1.3
* p95: 11.6
* p99: 15

### Vertx-Ktorm
* min: 0.2
* max: 91.4
* median: 0.4
* p95: 7
* p99: 9

### Vertx-Spring
* Numbers for this server are extermely high, I think I am doing something wrong with this configuration, tests canceled.
