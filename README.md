## Ejecutar con Docker

---
### 1. Descargar la imagen:
- docker pull nacho2070/webservice-app:latest
### 2. Ejecutar la imgaen:
- docker run -d -p 8080:8080 nacho2070/webservice-app:latest
### 3. Probar los Endpoints
- Una vez que el contenedor esté en ejecución, probar los endpoints del servicio web enviando solicitudes a:
  http://localhost:8080/
---
## Ejecutar localmente
### Requisitos:
1. Asegúrate de tener instalada la versión Java 17 o una compatible.
2. Asegúrate de tener instalado Maven.
3. Clonar el repositorio:
   ```bash
   git clone https://github.com/your-repo/webservice-app.git
---
4. Abrir el proyecto en IDE (como IntelliJ IDEA o Eclipse).
5. Ejecutar metodo main en clase WebServiceApplication.

## Endpoints

### 1. GET `http://localhost:8080/customer/`
- Recupera la lista de todos los clientes.
### 2. GET `http://localhost:8080/customer/{id}`
- Recupera un cliente específico por su ID.
### 3. POST `http://localhost:8080/customer/`
 ```json
    {
      "id": 1,
      "name": "Example",
      "email": "example@gmail.com",
      "phoneNumber": 123456789
    }
```
- Crea un nuevo customer.

### 4. PUT `http://localhost:8080/customer/{id}`
- Actualiza un customer existente.
### 5. DELETE `http://localhost:8080/customer/{id}`
- Elimina un cliente por su ID.
