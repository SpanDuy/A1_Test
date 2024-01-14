# A1_Test

### Задание 1

Для задания 1 был выбран тип данных Long, потому что в Java нет unsigned int, а при использовании int32 происходит переполнение.

### Задание 2

Выражение стремится к единице.

### Задание 3

Запрос для парсинга файла logins.csv

```
curl -X POST "http://localhost:8080/api/logins/parse 
```

Запрос для парсинга файла postings.csv

```
curl -X POST "http://localhost:8080/api/postings/parse 
```

Запрос для вывода данных в периоде с startDate по endDate и authorizedDelivery = false

```
curl -X GET "http://localhost:8080/api/postings/getByPeriod?startDate=2019-01-01&endDate=2023-12-31&authorizedDelivery=false
```
