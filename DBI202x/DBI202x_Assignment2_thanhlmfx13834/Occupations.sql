SELECT Doctor, Professor, Singer, Actor
FROM (SELECT ROW_NUMBER() OVER (PARTITION BY Occupation ORDER BY Name) rowNum, *
     FROM Occupations) AS tempTbl
PIVOT
    (MIN(Name) FOR Occupation In (Doctor, Professor, Singer, Actor)) AS pivotTbl