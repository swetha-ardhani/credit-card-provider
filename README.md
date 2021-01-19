# credit-card-provider
To add credit card accounts and to Return as a List


Two REST Endpoints implemented
•	"Add" will create a new credit card for a given name, card number, and limit
•	Card numbers will be validated using Luhn 10
•	New cards start with a £0 balance
•	for cards not compatible with Luhn 10, returns an error
•	"Get all" returns all cards in the system

Validation
•	All input and output will be JSON
•	Credit card numbers may vary in length, up to 19 characters
•	Credit card numbers will always be numeric

Technical Details
•	Created the RESTful API using Spring Boot and Used Maven for dependency management
•	compiler: Java8

Swagger: 
http://localhost:8080/credit-card/v2/api-docs
http://localhost:8080/credit-card/swagger-ui.html
