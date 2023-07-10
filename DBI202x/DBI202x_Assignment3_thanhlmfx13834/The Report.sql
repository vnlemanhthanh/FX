SELECT CASE when grade >=8 then name
            else null
            end as checkgrade ,
    grade, marks
FROM Students, Grades
WHERE marks BETWEEN min_mark and max_mark
ORDER BY grade DESC, name

