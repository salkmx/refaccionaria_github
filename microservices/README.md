# Refaccionaria microservicios (Spring Boot)

Este directorio incluye un MVP con 4 servicios:

- `gateway-service` (puerto 8080)
- `auth-service` (puerto 8081)
- `catalog-service` (puerto 8082)
- `orders-service` (puerto 8083)

## Ejecutar en local

```bash
cd microservices
mvn clean package
```

En terminales separadas:

```bash
cd microservices/auth-service && mvn spring-boot:run
cd microservices/catalog-service && mvn spring-boot:run
cd microservices/orders-service && mvn spring-boot:run
cd microservices/gateway-service && mvn spring-boot:run
```

## Endpoints de ejemplo (vía gateway)

- `POST http://localhost:8080/api/auth/login`
- `GET http://localhost:8080/api/products`
- `POST http://localhost:8080/api/orders`
