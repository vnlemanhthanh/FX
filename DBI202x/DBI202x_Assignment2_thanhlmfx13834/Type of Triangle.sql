SELECT
    CASE
        WHEN A<=0 or B<=0 or C<=0 or A+B<=C or B+C<=A or C+A<=B THEN 'Not A Triangle'
        WHEN A=B and B=C THEN 'Equilateral'
        WHEN A<>B and B<>C and C<>A THEN 'Scalene'
        ELSE 'Isosceles'
    END AS Result
    FROM TRIANGLES