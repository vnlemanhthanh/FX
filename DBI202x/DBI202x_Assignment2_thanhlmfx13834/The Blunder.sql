SELECT CAST(CEILING(AVG((Salary - REPLACE(Salary,0,''))*1.0)) AS int) 
FROM Employees