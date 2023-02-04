SELECT MONTH(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where CAR_ID IN 
(SELECT CAR_ID 
 from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
 where START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01' 
 group by CAR_ID 
 having count(*) >= 5) 
and START_DATE >= '2022-08-01' AND START_DATE < '2022-11-01'
group by MONTH, CAR_ID
order by MONTH, CAR_ID desc