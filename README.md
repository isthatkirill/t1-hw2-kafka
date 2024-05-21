## ДЗ №2 Т1 Холдинг

### Функциональность

Система включает в себя два микросервиса: 

1. Producer service - принимает POST-запросы с метриками, отправляет их в топик `metrics-topic` в kafka.
2. Consumer service - принимает метрики из топика `metrics-topic` и анализирует их. 

> *Метрики* представляют собой некоторые данные о выполнении http-запросов. 

### Эндпоинты

Примеры http-запросов есть в postman-коллекции.

Producer service имеет один единственный эндпоинт:

- POST `/metrics` - добавление новой метрики

Пример запроса:

```json
POST /metrics

Request body:
{
"method": "GET",
"path": "/api/v1/users",
"requestedAt": "2024-05-13 12:40:35",
"responseTime": 228,
"memoryUsedMB": 30
}
```

Consumer service имеет несколько эндпоинтов для получения метрик:

- GET `/metrics` - получение всех метрик
- GET `/metrics/{id}` - получение метрики по id
- GET `/metrics/abnormal` - получение аномальных метрик

> Под *аномальным* будем понимать такое выполнение http-запроса, которое заняло либо в 2 раза больше 
> времени, либо использовало в 2 раза больше памяти, чем средние значения других таких запросов с тем же http-методом по тому же пути.

Пример запроса:

```json
GET /metrics/abnormal

Response body:
{
"method": "GET",
"path": "/api/v1/users",
"requestedAt": "2023-05-11 13:51:35",
"responseTime": 60,
"memoryUsedMB": 1400
}
```

### Инструкция по запуску

1. Склонируйте репозиторий `git clone https://github.com/isthatkirill/t1-hw2-kafka.git`

2. Перейдите в директорию с проектом `cd t1-hw2-kafka`

3. Приложение полностью контейнеризованно. Запустите его с помощью `docker-compose up`

4. !!! `.env`-файл содержит параметры запуска контейнеров. При необходимости замените их.

### Используемые технологии и библиотеки

- Spring Boot
- Spring Data JPA
- Apache Kafka
- Docker
- Lombok
- Mapstruct
- PostgreSQL
- Liquibase
