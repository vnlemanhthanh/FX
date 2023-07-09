SELECT country.continent, AVG(city.population) 
FROM country
JOIN city
ON city.countrycode = country.code
GROUP BY country.continent