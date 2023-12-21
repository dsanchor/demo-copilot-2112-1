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

## Desplegar en AKS (Azure Kubernetes Service)

### Variables de entorno

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo2112
```

### Obtener credenciales

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

### Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

### Desplegar aplicación

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

### Obtener IP pública

```bash
export SVC_IP=$(kubectl get svc my-springboot-app-service -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

### Probar con curl

```bash
curl -X GET http://$SVC_IP/api/hello
```