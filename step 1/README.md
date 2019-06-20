# Scumm Bistro Step1
Formación de desarrollo y testing

## Requerimientos
Tener Docker instalado (descargar Docker Desktop desde https://www.docker.com/)

## Configuración
Introducir las variables entorno en el Launch App, que se encuentran en docker-compose.yml. 
Se debe reemplazar "scummmongo" por "localhost"
- SCUMM_AMQP_SERVER
- SCUMM_MONGODB_URI

## Despliegue

Para arrancar el proyecto con los dockers
```
./gradlew scumm-api:installBootDist
docker-compose build
docker-compose up -d
```

