SELECT SUM(CITY.Population) 
FROM CITY 
JOIN COUNTRY 
ON CITY.CountryCode = COUNTRY.Code 
WHERE Continent = 'Asia'