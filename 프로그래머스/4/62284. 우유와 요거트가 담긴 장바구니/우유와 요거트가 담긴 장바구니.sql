-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS 
where CART_ID IN (
    SELECT A.CART_ID FROM (
            SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = 'Milk'
        ) as A JOIN (
            SELECT CART_ID FROM CART_PRODUCTS WHERE NAME = 'Yogurt'
        ) as B ON A.CART_ID = B.CART_ID
    
)
group by CART_ID
order by CART_ID;