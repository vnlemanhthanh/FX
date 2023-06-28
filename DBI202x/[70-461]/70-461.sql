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
[EmployeeLastName],[EmployeeGovermentID],[DateOfBirth],[Department],[EmployeeNumber])
VALUES ('Jossef', 'H', 'Wright', 'TX593671R', '19711224', 'Litigation',131);

INSERT INTO tblEmployee
VALUES  (1, 'Dylan', 'A', 'Word', 'HN513777D', '19920914', 'Customer Relations'),
        (2,'Jossef', 'H', 'Wright', 'TX593671R', '19711224', 'Litigation')

select * from tblEmployee
where [EmployeeLastName] >= 'Word'

select * from tblEmployee 
where [EmployeeLastName] like 'W%'

Select * from tblEmployee
where [EmployeeLastName] like '[t-t]%'

-- % = 0-infinity characters
-- _ = 1 character
-- [A-G] = In the range A-G.
-- [AGQ] = A, G or Q.
-- [^AGQ] = NOT A, G or Q.

select * from tblEmployee
where EmployeeLastName like '[_]%'

select * from tblEmployee
where EmployeeLastName like '`%%' ESCAPE '`'

--SELECTing only part of a table – numbers

select * from tblEmployee
where not EmployeeNumber>200

select * from tblEmployee
where EmployeeNumber!=200

select * from tblEmployee
where EmployeeNumber>=200 and EmployeeNumber<=209

select * from tblEmployee
where not (EmployeeNumber>=200 and EmployeeNumber<=209)

select * from tblEmployee
where EmployeeNumber<200 or EmployeeNumber>209

select * from tblEmployee
where EmployeeNumber between 200 and 209

select * from tblEmployee
where EmployeeNumber not between 200 and 209

select * from tblEmployee
where EmployeeNumber in (200, 204, 208)

--Summarising an ordering data
select * from tblEmployee
where DateOfBirth between '19760101' and '19861231'

select * from tblEmployee
where DateOfBirth >= '19760101' and DateOfBirth < '19870101'

select * from tblEmployee
where year(DateOfBirth) between 1976 and 1986  -- DO NOT USE.

SELECT year(DateOfBirth) as YearOfDateOfBirth, count(*) as NumberBorn
FROM tblEmployee
GROUP BY year(DateOfBirth)

SELECT * FROM tblEmployee
where year(DateOfBirth) = 1967

SELECT year(DateOfBirth) as YearOfDateOfBirth, count(*) as NumberBorn
FROM tblEmployee
WHERE 1=1
GROUP BY year(DateOfBirth)
-- non-deterministic

SELECT year(DateOfBirth) as YearOfDateOfBirth, count(*) as NumberBorn
FROM tblEmployee
WHERE 1=1
GROUP BY year(DateOfBirth)
ORDER BY year(DateOfBirth) DESC
-- deterministic
