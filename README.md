please following the below steps to run the springboot application

step 1->clone the project into local machine

step 2->run the maven package command in terminal ./mvnw package(for mac)

step 3->cd to target folder

step 4->run the command in terminal java -jar jarfilename

step 5->copy the contents in data.sql in the static folder and run sql scripts into the local machine mysql

step 6->Run the below rest api endpoints

step 7->Rest endpoints are secured by spring security with 4 users
please use the basic authentication usernames and passwords,

user 1:username-user1 password-password1
user 2:username-user2 password-password2
user 3:username-user3 password-password3
user 4:username-user4 password-password4



port:http://localhost:8080

Expense
POST->/api/expenses
GET->/api/expenses
PUT->/api/expenses/{expenseId}
DELETE->/api/expenses/{expenseId}
Income
POST->/api/incomes
Reports
GET->/api/reports
Book Controller
GET->/api/books
Budget Controller
POST->/api/budgets
GET->/api/budgets


