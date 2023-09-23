# Spring Data JPA demo
The purpose of this project is to practice and demonstrate the features/annotations provided by the Spring Data JPA.


### Department:

- (GET) **localhost:8089/api/departments** : Fetches all the departments
- (POST) **localhost:8089/api/department** : Add new department
	- Body:
		```json
		{
		    "name": "IT"
		}
		```

### Employee:

- (GET) **localhost:8089/api/employees** : Fetches all the employees
- (POST) **localhost:8089/api/employee** : Add new employee
	- Body:
		```json
		{
		    "employeeName": "John doe",
		    "employeeDesignation": "Software Developer",
		    "departmentId": 1
		}
		```