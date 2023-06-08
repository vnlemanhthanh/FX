USE [70-461]
GO

DROP TABLE tblEmployee

CREATE TABLE tblEmployee(
EmployeeNumber INT NOT NULL,
EmployeeFirstName VARCHAR(50) NOT NULL,
EmployeeMiddleName VARCHAR(50),
EmployeeLastName VARCHAR(50) NOT NULL,
EMployeeGovermentID CHAR(10),
DateOfBirth DATE NOT NULL
)

DROP TABLE tblSecond

CREATE TABLE tblTransaction (
Amount SMALLMONEY NOT NULL,
DateOfTransaction SMALLDATETIME,
EmployeeNumber INT NOT NULL
)

