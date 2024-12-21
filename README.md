## Execute with docker

---
### 1. Pull the image:
- docker pull nacho2070/webservice-app:latest
### 2. Run the image:
- docker run -d -p 8080:8080 nacho2070/webservice-app:latest
### 3. Test the Endpoints
- Once the container is running, you can test the endpoints of the web service by sending requests to :
  http://localhost:8080/
---
## Execute locally
### Prerequisites:
1. Ensure you have **Java 17** or a compatible version installed.
2. Ensure you have **Maven** installed.
3. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/webservice-app.git
---

## Endpoints

### 1. GET `http://localhost:8080/customer/`
- Retrieve the list of all customers.
### 2. GET `http://localhost:8080/customer/{id}`
- Retrieve a single customer by their ID.
### 3. POST `http://localhost:8080/customer/`
- Create a new customer.
### 4. PUT `http://localhost:8080/customer/{id}`
- Update an existing customer.
### 5. DELETE `http://localhost:8080/customer/{id}`
- Delete a customer by their ID.
