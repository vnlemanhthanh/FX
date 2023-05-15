SELECT CONCAT(Name,'(',LEFT(Occupation,1),')') AS Result
    FROM OCCUPATIONS
    ORDER BY Result

SELECT CONCAT('There are a total of ',(COUNT(Occupation)),' ',LOWER(Occupation),'s.') AS Result
    FROM OCCUPATIONS
    GROUP BY Occupation
    ORDER BY COUNT(Occupation) ASC, Occupation ASC