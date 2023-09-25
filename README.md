# Data relation with JPA mapping
This is a demonstration project for data mapping with Spring data JPA.

## One-to-One mapping:
For one-to-one mapping I used a **user** entity and connected it with the **userPersonalInfo** entity.

### API:
- (GET) localhost:8089/users: Get all users
- (POST) localhost:8089/user: Create a new user
	- **body**:
	```json
		{
		    "username": "shofiqul",
			"fullName": "Shofiqul Islam",
			"mobile": "01545454585",
			"address": "Dhaka"
		}
	```
- (DELETE) localhost:8089/user/{id}: Deletes a user by the given user id