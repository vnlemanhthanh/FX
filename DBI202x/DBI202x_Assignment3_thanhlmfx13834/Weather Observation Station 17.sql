SELECT CAST(LONG_W as Decimal(10,4))
FROM Station 
WHERE LAT_N = (SELECT min(LAT_N) FROM Station WHERE LAT_N > 38.7780)