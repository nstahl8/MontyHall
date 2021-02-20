# Monty Hall simulator

 This is a RESTful Monty Hall problem simulator (http://en.wikipedia.org/wiki/Monty_Hall_problem). It runs with spring-boot on port 8080.

## Installation

Use maven to install needed dependencies.

```bash
mvn clean
```

## Usage


To run all unit tests use:

```bash
mvn test
```
To start the application use:
```bash
mvn spring-boot:run
```

The server has two end-points.
One to keeps the door/box that you picked, and one that always swaps. The examples below run 10 simulations.
```curl
curl localhost:8080/simul/keep/10
curl localhost:8080/simul/swap/10
```
