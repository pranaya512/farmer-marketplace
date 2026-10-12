# AI-Powered Farmer Marketplace — Spring Boot backend

## Requirements
- Java 17+
- Maven
- MySQL 8+
- React frontend (separate project)

## Setup
1. Create a MySQL user/database or allow the configured connection to create `farmer_marketplace`.
2. Edit `src/main/resources/application.properties` and replace `YOUR_MYSQL_PASSWORD`.
3. Run from this folder: `mvn spring-boot:run`
4. API base URL: `http://localhost:8080/api`

## Main endpoints
- `POST /api/auth/register` — register FARMER or CUSTOMER
- `POST /api/auth/login` — verify credentials
- `GET /api/products` — list products; optional `?search=rice`
- `GET /api/products/farmer/{farmerId}` — farmer listings
- `POST /api/products/farmer/{farmerId}` — add product
- `PUT /api/products/{id}/farmer/{farmerId}` — update product
- `DELETE /api/products/{id}/farmer/{farmerId}` — delete product
- `GET /api/cart/{customerId}` — view cart
- `POST /api/cart/{customerId}` — add/update cart item
- `DELETE /api/cart/{customerId}/items/{itemId}` — remove item
- `POST /api/orders/checkout/{customerId}` — place order from cart
- `GET /api/orders/customer/{customerId}` — order history
- `PATCH /api/orders/{orderId}/farmer/{farmerId}/status?status=CONFIRMED` — update order status
- `GET /api/ai/price-prediction/{productId}` — demo price estimate
- `GET /api/ai/recommendations/{productId}` — category-based recommendations

## Example JSON
Register:
{"name":"Example Farmer","email":"farmer@example.com","password":"secret123","role":"FARMER","phone":"9999999999","address":"Telangana"}
Add product:
{"name":"Tomato","description":"Fresh tomatoes","category":"Vegetables","price":30,"quantity":100,"unit":"kg","imageUrl":""}
Add to cart:
{"productId":1,"quantity":2}
Checkout:
{"deliveryAddress":"Hyderabad, Telangana"}

## Important limitations
This is an educational starter, not a production-secure system. The login endpoint does not issue a session/JWT and endpoints currently trust IDs supplied in the URL; add Spring Security with JWT and authorization before public deployment. Price prediction is a placeholder range around the listed price, not a trained AI model. Recommendations are category-based and do not yet learn from views, searches, or purchases. Payments, image upload, pagination, and delivery tracking integrations are not included.
