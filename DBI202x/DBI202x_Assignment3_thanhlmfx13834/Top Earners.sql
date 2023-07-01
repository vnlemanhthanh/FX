SELECT max(salary * months), COUNT(*)
FROM Employee
WHERE (salary * months) = (select max(salary * months) from Employee)