SET @i = -1;

SELECT (@i := @i + 1) AS HOUR
        , (SELECT COUNT(*) 
           FROM animal_outs 
           WHERE HOUR(datetime) = @i) AS COUNT
FROM animal_outs
WHERE @i < 23