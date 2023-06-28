CREATE DATABASE [70-461]
go

USE [70-461]
GO

DROP TABLE tblEmployee
 
SELECT * FROM tblEmployee

CREATE TABLE tblEmployee(
EmployeeNumber INT NOT NULL,
EmployeeFirstName VARCHAR(50) NOT NULL,
EmployeeMiddleName VARCHAR(50),
EmployeeLastName VARCHAR(50) NOT NULL,
EmployeeGovermentID CHAR(10),
DateOfBirth DATE NOT NULL
)

ALTER TABLE tblEmployee
ADD Department VARCHAR(10);

INSERT INTO tblEmployee
VALUES (132, 'Dylan', 'A', 'Word', 'HN513777D', '19920914', 'Customer Relations')

ALTER TABLE tblEmployee
DROP COLUMN Department

ALTER TABLE tblEmployee
ADD Department VARCHAR(15)

ALTER TABLE tblEmployee
ALTER COLUMN Department VARCHAR(20)

ALTER TABLE tblEmployee
ALTER COLUMN Department VARCHAR(19)

SELECT LEN('Customer Relations')

INSERT INTO tblEmployee([EmployeeFirstName],[EmployeeMiddleName],
[EmployeeLastName], [EmployeeGovermentID],[DateOfBirth], [Department],[EmployeeNumber])
VALUES ('Jossef', 'H', 'Wright', 'TX593671R', '19711224', 'Litigation',131);
