-- 코드를 입력하세요
SELECT substr(product_code, 0, 2),
    count(substr(product_code, 0, 2)) as products
from product
group by substr(product_code, 0, 2)
order by substr(product_code, 0, 2);
