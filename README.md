# E-Commerce Backend API System

A backend REST API project developed using Java and Spring Boot for managing users, products, shopping carts and orders.

## Features

- User CRUD operations
- Product CRUD operations
- Cart management
- Order creation and status management
- MySQL database integration
- Spring Data JPA / Hibernate
- Input validation
- RESTful HTTP methods and status codes
- Layered architecture: Controller → Service → Repository

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST API
- Maven
- Postman

## Project Structure

```text
controller
service
repository
entity
```

## Database Setup

The application uses MySQL. Create a database named `ecommerce_db`, or keep `createDatabaseIfNotExist=true` in `application.properties`.

Update:

```properties
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

with your local MySQL credentials.

## Run the Project

1. Open the project in IntelliJ IDEA or another Java IDE.
2. Make sure Java 17 and MySQL are installed.
3. Update MySQL username/password.
4. Run `ECommerceApplication.java`.
5. Server starts at `http://localhost:8080`.

## API Endpoints

### Users

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users` | Create user |
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

### Products

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/products` | Create product |
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |

### Cart

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/cart` | Add product to cart |
| GET | `/api/cart/user/{userId}` | View user's cart |
| PUT | `/api/cart/{id}` | Update quantity |
| DELETE | `/api/cart/{id}` | Remove cart item |

### Orders

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/orders` | Create order |
| GET | `/api/orders` | Get all orders |
| GET | `/api/orders/{id}` | Get order by ID |
| GET | `/api/orders/user/{userId}` | Get user's orders |
| PATCH | `/api/orders/{id}/status?status=SHIPPED` | Update order status |
| DELETE | `/api/orders/{id}` | Delete order |

## Sample Request

### Create User

```json
{
  "name": "Seeta patil",
  "email": "patil@gmail.com",
  "phone": "1234567890"
}
```

### Create Product

```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.0,
  "stock": 25
}
```

### Add Cart Item

```json
{
  "userId": 1,
  "productId": 1,
  "quantity": 2
}
```

### Create Order

```json
{
  "userId": 1,
  "totalAmount": 1598.0,
  "status": "PLACED"
}
```

## Testing

APIs can be tested using Postman by sending JSON requests and validating HTTP status codes and responses.

## Author

Supriya Chavan https://github.com/Chavan72
