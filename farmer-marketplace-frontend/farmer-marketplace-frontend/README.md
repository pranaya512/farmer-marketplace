# Farmer Marketplace Frontend (React + Vite)

## Requirements
- Node.js 18 or newer
- The Spring Boot backend running at `http://localhost:8080`

## Run in Windows / IntelliJ
1. Extract `farmer-marketplace-frontend.zip`.
2. Open the extracted `farmer-marketplace-frontend` folder in IntelliJ IDEA (or VS Code).
3. Open the Terminal at the project folder.
4. Run:
   ```bash
   npm install
   npm run dev
   ```
5. Open the local URL printed in the terminal, usually `http://localhost:5173`.

## Features
- Responsive marketplace home page and product search/category filters
- Customer/farmer registration and login forms
- Farmer product create, edit and delete UI
- Customer basket, checkout and order history
- Calls the Spring Boot APIs under `http://localhost:8080/api`
- Price prediction and product recommendation API hooks

## Notes
- If the backend has no products, the shop displays sample products for visual preview. Sample items cannot be checked out; add real products with a farmer account.
- The frontend expects the API endpoints described in the backend README.
- For browser requests to work, the backend must allow requests from `http://localhost:5173` (CORS). If the browser console reports a CORS error, configure Spring Boot CORS for that origin.
- This is an educational starter. The backend's demo login is not production authentication and payment processing is not included.
