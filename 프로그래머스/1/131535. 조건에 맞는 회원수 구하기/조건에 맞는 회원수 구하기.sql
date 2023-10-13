-- 코드를 입력하세요
SELECT count(*) as USERS
from USER_INFO
where YEAR(JOINED) = 2021
and AGE BETWEEN 20 and 29;