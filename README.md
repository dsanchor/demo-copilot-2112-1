# Spring Boot Rest API Demo

## Compilar
    
```bash
mvn clean install
```

## Ejecutar

```bash
mvn spring-boot:run
```

## Probar con curl

```bash
curl -X GET http://localhost:8080/api/hello
```

## Probar operación reverse

```bash
curl http://localhost:8080/api/reverse?input=hello
```

## Probar operación remove vocals

```bash
curl http://localhost:8080/api/removevocals?input=hello
```

## Ejecutar pruebas unitarias

```bash
mvn test
```

## Containerizar

### Construir imagen

```bash
docker build -t spring-boot-rest-api-demo .
```

### Ejecutar contenedor

```bash
docker run -p 8080:8080 spring-boot-rest-api-demo
```