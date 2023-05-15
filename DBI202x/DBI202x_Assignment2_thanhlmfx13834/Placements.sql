SELECT Students.Name
FROM Students  
JOIN Friends ON Students.ID = Friends.ID
JOIN Packages p1 ON Students.ID = p1.ID
JOIN Packages p2 ON Friends.Friend_ID = p2.ID
WHERE p2.Salary > p1.Salary
ORDER BY p2.Salary