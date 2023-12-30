# Pix mercado pago with clean architecture

An API to generate pix transactions with qr-code using mercado pago api.

![clean-arch](https://miro.medium.com/v2/resize:fit:1400/0*iU9Ks05_GTtGh6zV.jpg)

### Used Technologies

* [Java](https://www.java.com/en/)
* [Docker](https://www.docker.com/)
* [Quarkus](https://pt.quarkus.io/)

## Dependencies and required versions

* Java - Version: 17
* Maven - Version: 3.8.2
* Quarkus - Version: 3.6.4
* Docker - Version: 24.0.7

### Getting started

* on Dev mode

```shell script
./mvnw compile quarkus:dev
```

or

```shell script
mvn compile quarkus:dev
```

* on Native mode

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

and then

```shell
./target/pix-mercado-pago-api-1.0-SNAPSHOT-runner
```

## How to run tests

```shell
./mvnw verify
```

or 

```shell
mvn verify
```

## Routes
```http request
POST /v1/pix
```

body:

```json
{
    "description": "test pix",
    "email": "email_user@email.com",
    "amount": 23
}
```

