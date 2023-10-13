-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF as f
JOIN ICECREAM_INFO as i
on f.FLAVOR = i.FLAVOR
where TOTAL_ORDER > 3000
and i.INGREDIENT_TYPE = 'fruit_based'
order by TOTAL_ORDER desc;