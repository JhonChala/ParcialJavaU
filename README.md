Below are the consumptions and an example for the endpoints created for the entities Product, Customer, Sale, Distributor and Employee:

1) Client

Get all clients:

GET http://parcialjava:4500/clients

Get client by ID:

GET http://parcialjava:4500/clients/{id}

Create new client:

POST http://parcialjava:4500/clients

Request body (JSON):

{
  "name": "Jhon Example",
  "email": "jhon@example.com",
  "address" : "Granada",
  "cellphone" : "123456789",  
}

Update client:

PUT http://parcialjava:4500/clients/{id}

Request body (JSON):

{
  "name": "Jhon Example Updated",
  "email": "jhon.updated@example.com",
  "address" : "Granada updated",
  "cellphone" : "987654321", 
}

Delete client:

DELETE http://parcialjava:4500/clients/{id}

2) Distributors

Get all distributors:

GET http://parcialjava:4500/distributors

Get distributor by ID:

GET http://parcialjava:4500/distributors/{id}

Create new distributor:

POST http://parcialjava:4500/distributors

Request body (JSON):

{
  "name": "Distributor Laureles",  
  "email": "distribuitorLaurel@example.com",
  "address" : "Laureles",
  "cellphone" : "1234567890",
  "company" : "Distribuitor Laurel"
}

Update distributor:

PUT http://parcialjava:4500/distributors/{id}

Request body (JSON):

{
  "name": "Distributor la 19 Updated",
  "email": "distribuitorLaurelUptd@example.com",
  "address" : "Laureles Uptds",
  "cellphone" : "1234567810",
  "company" : "Distribuitor Laurel Uptd"
}

Delete distributor:

DELETE http://parcialjava:4500/distributors/{id}

3. Employees

Get all employees:

GET http://parcialjava:4500/employees

Get employee by ID:

GET http://parcialjava:4500/employees/{id}

Create new employee:

POST http://parcialjava:4500/employees

Request body (JSON):

{
  "name": "Jhon Jairo",
  "email": "employeeJhon@example.com",
  "address" : "Patria",
  "cellphone" : "3424231334",
  "active" : true
}

Update employee:

PUT http://parcialjava:4500/employees/{id}

Request body (JSON):

{
  "name": "Jhon Jairo",
  "email": "employeeJhon@example.com",
  "address" : "Patria",
  "cellphone" : "3424231334",
  "active" : false
}

Delete employee:

DELETE http://parcialjava:4500/employees/{id}

4. Product

Get all products:

GET http://parcialjava:4500/products

Get product by ID:

GET http://parcialjava:4500/products/{id}

Create new product:

POST http://parcialjava:4500/products

Request body (JSON):

{
  "name": "Laptop",
  "price": 1200.0,
  "available" : true
}

Update product:

PUT http://parcialjava:4500/products/{id}

Request body (JSON):

{
 "name": "Laptop",
  "price": 1400.0,
  "available" : false
}

Delete product:

DELETE http://parcialjava:4500/products/{id}

5. Sales

Get all sales:

GET http://parcialjava:4500/sales

Get sale by ID:

GET http://parcialjava:4500/sales/{id}

Create new sale:

POST http://parcialjava:4500/sales

Request body (JSON):

{
  "nameProduct": "Laptop",
  "salePrice": 1400.0,
  "nameClient": "Jhon"
}

Update sale:

PUT http://parcialjava:4500/sales/{id}

Request body (JSON):

{
   "nameProduct": "Gaming Laptop",
  "salePrice": 3400.0,
  "nameClient": "Jhon"
}

Delete sale:

DELETE http://parcialjava:4500/sales/{id}
