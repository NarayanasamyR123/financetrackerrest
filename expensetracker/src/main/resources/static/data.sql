CREATE DATABASE expensedb;
USE expensedb;
CREATE TABLE Income
(
id INT AUTO_INCREMENT,
incomesrc VARCHAR(50) NOT NULL,
incomeamt DECIMAL(7,2) NOT NULL,
creationdt VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);
CREATE TABLE Budget
(
id INT AUTO_INCREMENT,
itemname VARCHAR(50) NOT NULL,
budgetamt DECIMAL(7,0) NOT NULL,
createddt VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);
CREATE TABLE Expense
(
expid INT AUTO_INCREMENT,
expname VARCHAR(50) NOT NULL,
expamount DECIMAL(7,0) NOT NULL,
expdesc VARCHAR(255) NOT NULL,
createddt VARCHAR(50) NOT NULL,
PRIMARY KEY(expid)
);
CREATE TABLE incomeexpensejoin
(
incomeid INT,
expenseid INT,
PRIMARY KEY(incomeid,expenseid),
FOREIGN KEY(incomeid) REFERENCES Income(id),
FOREIGN KEY(expenseid) REFERENCES Expense(expid)
); 
CREATE TABLE incomebudgetjoin
(
incomeid INT,
budgetid INT,
PRIMARY KEY(incomeid,budgetid),
FOREIGN KEY(incomeid) REFERENCES Income(id),
FOREIGN KEY(budgetid) REFERENCES Budget(id)
); 
