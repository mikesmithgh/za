# 🍕 za
A simple pizza topping tracking system.

https://github.com/mikesmithgh/za/assets/10135646/6f823c62-ce6d-4514-a66d-830753ea0682

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
### Order Pizza
```sh
echo -n 'CgrirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJvirJsK4qyb4qyb4qyb4qyb4qyb4qyb8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6virJvirJvirJvirJvirJvirJvirJvirJvirJvirJvwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq+Ksm+Ksm+Ksm+Ksm+Ksm+KsmwrirJvirJvwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r4qyb4qyb8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq+Ksm+KsmwrirJvirJvwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r4qyb4qyb8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq/Cfn6vwn5+r8J+fq+Ksm+KsmwrirJvirJvwn5+r8J+fq/Cfn6vwn5+o8J+fqPCfn6jwn5+l8J+fpfCfn6Xwn5+o8J+fqPCfn6jwn5+o8J+fq/Cfn6vwn5+r4qyb4qyb8J+fq/Cfn6vwn5+r8J+fqPCfn6jwn5+o8J+fpfCfn6Xwn5+l8J+fqPCfn6jwn5+o8J+fqPCfn6vwn5+r8J+fq+Ksm+KsmwrirJvirJvirJvwn5+o8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fpfCfn6jwn5+o8J+fqPCfn6jwn5+l8J+fpeKsm+Ksm+Ksm+Ksm/Cfn6jwn5+o8J+fqPCfn6jwn5+o8J+fpfCfn6Xwn5+l8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l4qyb4qyb4qybCuKsm+Ksm+Ksm/Cfn6jwn5+l8J+fpfCfn6jwn5+o8J+fqPCfn6Xwn5+o8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l4qyb4qyb4qyb4qyb8J+fqPCfn6Xwn5+l8J+fqPCfn6jwn5+o8J+fpfCfn6jwn5+o8J+fqPCfn6jwn5+o8J+fpfCfn6XirJvirJvirJsK4qyb4qyb4qyb4qyb8J+fpfCfn6Xwn5+o8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fqPCfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qyb8J+fpfCfn6Xwn5+o8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fqPCfn6jwn5+o4qyb4qyb4qyb4qybCuKsm+Ksm+Ksm+Ksm/Cfn6jwn5+o8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fpfCfn6Xwn5+o8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm/Cfn6jwn5+o8J+fqPCfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fpfCfn6Xwn5+o8J+fqOKsm+Ksm+Ksm+KsmwrirJvirJvirJvirJvirJvwn5+o8J+fpfCfn6Xwn5+o8J+fqPCfn6Xwn5+l8J+fpfCfn6Xwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fqPCfn6Xwn5+l8J+fqPCfn6jwn5+l8J+fpfCfn6Xwn5+l8J+fqOKsm+Ksm+Ksm+Ksm+KsmwrirJvirJvirJvirJvirJvwn5+l8J+fpfCfn6Xwn5+l8J+fqPCfn6jwn5+l8J+fpfCfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fpfCfn6Xwn5+l8J+fpfCfn6jwn5+o8J+fpfCfn6Xwn5+o8J+fqOKsm+Ksm+Ksm+Ksm+KsmwrirJvirJvirJvirJvirJvirJvwn5+l8J+fpfCfn6Xwn5+o8J+fqPCfn6jwn5+o8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm/Cfn6Xwn5+l8J+fpfCfn6jwn5+o8J+fqPCfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qybCuKsm+Ksm+Ksm+Ksm+Ksm+Ksm/Cfn6Xwn5+l8J+fpfCfn6jwn5+o8J+fqPCfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fpfCfn6Xwn5+l8J+fqPCfn6jwn5+o8J+fqPCfn6jirJvirJvirJvirJvirJvirJsK4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fpfCfn6jwn5+o8J+fpfCfn6Xwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fpfCfn6jwn5+o8J+fpfCfn6Xwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qybCuKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm/Cfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm/Cfn6jwn5+o8J+fqPCfn6Xwn5+l8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm+KsmwrirJvirJvirJvirJvirJvirJvirJvirJvwn5+o8J+fqPCfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fqPCfn6jwn5+o8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+KsmwrirJvirJvirJvirJvirJvirJvirJvirJvwn5+o8J+fqPCfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb8J+fqPCfn6jwn5+o8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+KsmwrirJvirJvirJvirJvirJvirJvirJvirJvirJvwn5+o8J+fqOKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm/Cfn6jwn5+o4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qyb4qybCuKsm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksm+Ksmwo=' | base64 -d
```
```
⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛⬛⬛⬛⬛
⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛
⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫🟫⬛⬛
⬛⬛🟫🟫🟫🟨🟨🟨🟥🟥🟥🟨🟨🟨🟨🟫🟫🟫⬛⬛🟫🟫🟫🟨🟨🟨🟥🟥🟥🟨🟨🟨🟨🟫🟫🟫⬛⬛
⬛⬛⬛🟨🟨🟨🟨🟨🟥🟥🟥🟨🟨🟨🟨🟥🟥⬛⬛⬛⬛🟨🟨🟨🟨🟨🟥🟥🟥🟨🟨🟨🟨🟥🟥⬛⬛⬛
⬛⬛⬛🟨🟥🟥🟨🟨🟨🟥🟨🟨🟨🟨🟨🟥🟥⬛⬛⬛⬛🟨🟥🟥🟨🟨🟨🟥🟨🟨🟨🟨🟨🟥🟥⬛⬛⬛
⬛⬛⬛⬛🟥🟥🟨🟨🟨🟨🟨🟥🟥🟨🟨🟨⬛⬛⬛⬛⬛⬛🟥🟥🟨🟨🟨🟨🟨🟥🟥🟨🟨🟨⬛⬛⬛⬛
⬛⬛⬛⬛🟨🟨🟨🟨🟨🟨🟥🟥🟥🟥🟨🟨⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨🟨🟨🟥🟥🟥🟥🟨🟨⬛⬛⬛⬛
⬛⬛⬛⬛⬛🟨🟥🟥🟨🟨🟥🟥🟥🟥🟨⬛⬛⬛⬛⬛⬛⬛⬛🟨🟥🟥🟨🟨🟥🟥🟥🟥🟨⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛🟥🟥🟥🟥🟨🟨🟥🟥🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛🟥🟥🟥🟥🟨🟨🟥🟥🟨🟨⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛🟥🟥🟥🟨🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟥🟥🟥🟨🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛🟥🟥🟥🟨🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟥🟥🟥🟨🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛🟥🟨🟨🟥🟥🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟥🟨🟨🟥🟥🟨⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟥🟥🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟥🟥🟨⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛🟨🟨⬛⬛⬛⬛⬛⬛⬛⬛⬛
⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛
```
