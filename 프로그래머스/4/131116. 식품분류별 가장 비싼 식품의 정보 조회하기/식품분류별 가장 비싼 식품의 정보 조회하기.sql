-- 코드를 입력하세요
SELECT CATEGORY, PRICE AS 'MAX_PRICE', PRODUCT_NAME
FROM FOOD_PRODUCT
where (CATEGORY, PRICE) IN (
        SELECT CATEGORY, MAX(PRICE) FROM FOOD_PRODUCT WHERE CATEGORY REGEXP '과자|국|김치|식용유' group by CATEGORY
    )
and CATEGORY REGEXP '과자|국|김치|식용유'
order by PRICE DESC;