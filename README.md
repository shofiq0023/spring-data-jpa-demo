# Data relation with JPA mapping
This is a demonstration project for data mapping with Spring data JPA.

### Some pointers of this project:
- There is no authentication in this project as this is a demo project.
- This project demonstrate the JPA Mapping like One-to-One, Many-to-One, Many-to-Many mapping.

# One-to-One mapping:
For one-to-one mapping I used a **user** entity and connected it with the **userPersonalInfo** entity.

### API:
- **localhost:8089/users** [GET]: Get all users.
- **localhost:8089/user** [POST]: Create a new user.
	- body:
	```json
	{
		"username": "shofiqul",
		"fullName": "Shofiqul Islam",
		"mobile": "01618638686",
		"address": "Dhaka"
	}
	```
- **localhost:8089/user/{id}** [POST]: Deletes a user by the given user id

# One-to-Many:
For the One-to-Many demo I used two example. First one is the relation between a department and employee. And Second one is the relation between a Author and a book.

For the first example a **Department** and a **Employee** entity is used.

### API (For employee):
- **localhost:8089/employees** [GET]: Get all employees.
- **localhost:8089/employee/{depId}** [GET]: Get employee by department id.