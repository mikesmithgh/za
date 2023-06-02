⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛⬛⬛⬛
⬛🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫⬛
⬛🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫⬛
⬛🟫🟫🟫🟨🟨🟨🟥🟥🟥🟨🟨🟨🟨🟫🟫🟫⬛
⬛⬛🟨🟨🟨🟨🟨🟥🟥🟥🟨🟨🟨🟨🟥🟥⬛⬛
⬛⬛🟨🟥🟥🟨🟨🟨🟥🟨🟨🟨🟨🟨🟥🟥⬛⬛
⬛⬛⬛🟥🟥🟨🟨🟨🟨🟨🟥🟥🟨🟨🟨⬛⬛⬛
⬛⬛⬛🟨🟨🟨🟨🟨🟨🟥🟥🟥🟥🟨🟨⬛⬛⬛
⬛⬛⬛⬛🟨🟥🟥🟨🟨🟥🟥🟥🟥🟨⬛⬛⬛⬛
⬛⬛⬛⬛🟥🟥🟥🟥🟨🟨🟥🟥🟨🟨⬛⬛⬛⬛
⬛⬛⬛⬛⬛🟥🟥🟥🟨🟨🟨🟨🟨⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛🟥🟥🟥🟨🟨🟨🟨🟨⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛🟥🟨🟨🟥🟥🟨⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛🟨🟨🟨🟥🟥🟨⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛
# 🍕 za
A simple pizza topping tracking system.

## 🏃 Build and Run
```sh
./gradlew clean build docker && docker-compose up
```

## 👉 Endpoints
| Method | Path             | Description                                                  | Input example                                                           | Output example                                                                       |
|--------|------------------|--------------------------------------------------------------|-------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
| GET    | /user            | List all users                                               |                                                                         | `[ { "id": 1, "email": "mike@fakeemail.com" } ]` |                                   |
| POST   | /user            | Add user with given email address                            | `{ "email": "someone@fakeemail.com" }`                                  |                                                                                      |
| GET    | /usertoppings    | List all toppings and number of unique customers per topping |                                                                         | `[ { "topping": "pepperoni", "count": 3 }, { "topping": "pineapple", "count": 2 } ]` |
| POST   | /usertoppings    | Add user with email and list of toppings                     | `{ "email": "someone@fakeemail.com", "toppings": [ "eggs", "bacon"] }"` |                                                                                      |
| GET    | /topping         | List all toppings                                            |                                                                         | `[ { "id": 1, "name": "pepperoni" }, { "id": 2, "name": "sausage" } ]`               |
| POST   | /topping         | Add a topping                                                | `{ "name": "tomatoes" }`                                                |                                                                                      |
| GET    | /topping/special | List my favorite toppings                                    |                                                                         | `[ "pepperoni", "sausage", "mushrooms", "green peppers", "onions" ]`                 |

## 📫 Postman
A postman collection with all endpoints defined is available at [postman/za.postman_collection.json](./postman/za.postman_collection.json). 
To use the collection open your postman workspace, navigate to `Import` > `File` and select the postman collection JSON file.

## 🔨 Troubleshooting
### Connect to the database
You can use the following command to connect to `zadb` with psql.
```sh
PGPASSWORD=postgrespass psql --username=postgres --host=localhost --port=5432 --dbname=zadb
```

