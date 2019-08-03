# User Account Transaction Application
Sample backend application that allows users to view accounts and view related transactions of any specific account they hold. This application is designed using Maven with spring boot framework as base. Below frameworks are used to accompolish this project
* Spring Boot Parent
* Spring Boot Web
* Spring Boot JPA
* Spring Boot Test
* Spring H2 in memory DB

# Below RestApi are exposed as part of this project
# http://localhost:8504/sample/accounts
	This API will provide the list of accounts and related details owned by a user
	
Sample Response:

[{"accountNumber":"4537152876","accountName":"AUSavings726","accountType":"SAVINGS","balanceDate":"08/11/2018","currency":"AUD","openingAvailableBalance":"84,327.39"},{"accountNumber":"4537658648","accountName":"SGCurrent745","accountType":"CURRENT","balanceDate":"24/04/2018","currency":"SGD","openingAvailableBalance":"124,327.22"},{"accountNumber":"4537152465","accountName":"SGSavings654","accountType":"SAVINGS","balanceDate":"01/03/2018","currency":"SGD","openingAvailableBalance":"92,327.56"},{"accountNumber":"4536778557","accountName":"AUSavings476","accountType":"SAVINGS","balanceDate":"11/01/2018","currency":"AUD","openingAvailableBalance":"134,566.87"}]

# http://localhost:8504/sample/accounts/{accountNo}
	This API will provide account specific information since account number is passed as path value
	
Sample Response:

{"accountNumber":"4537152876","accountName":"AUSavings726","accountType":"SAVINGS","balanceDate":"08/11/2018","currency":"AUD","openingAvailableBalance":"84,327.39"}	

# http://localhost:8504/sample/accounts/{accountNo}/transactions
	This API will provide all transaction details for an user account that is passed in the path value
	
Sample Response:

{"accountNumber":"4537152876","accountName":"AUSavings726","accountType":"SAVINGS","transactions":[{"valueDate":"Apr, 24, 2018","currency":"AUD","transType":"CREDIT","debitAmount":null,"creditAmount":"134,566.87","transNarrative":"erew"},{"valueDate":"Apr, 24, 2018","currency":"AUD","transType":"CREDIT","debitAmount":null,"creditAmount":"134,566.87","transNarrative":"erew"},{"valueDate":"Apr, 24, 2018","currency":"AUD","transType":"CREDIT","debitAmount":null,"creditAmount":"134,566.87","transNarrative":"erew"},{"valueDate":"Apr, 24, 2018","currency":"AUD","transType":"CREDIT","debitAmount":null,"creditAmount":"134,566.87","transNarrative":"erew"},{"valueDate":"Apr, 24, 2018","currency":"AUD","transType":"CREDIT","debitAmount":null,"creditAmount":"134,566.87","transNarrative":"erew"}]}

#Database:
	InMemory Spring H2 database is used for this sample application. User the URL http://localhost:8504/sample/h2 to access the H2 DB console. If prompted to fill DB related details, below credentials should be given. This is also available in application.properties file
	
spring.datasource.url=jdbc:h2:file:~/sampledb

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=1234qwer$ 


 
