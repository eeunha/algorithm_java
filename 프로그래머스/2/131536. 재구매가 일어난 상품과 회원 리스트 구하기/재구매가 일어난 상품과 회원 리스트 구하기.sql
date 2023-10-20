-- select * from online_sale;

-- 2. 재구매한 회원의 id와 상품의 id 출력하기

-- 3. 회원 id 오름차순 정렬, 상품 id 내림차순 정렬

-- 1. 동일한 회원이 동일한 상품을 재구매한 데이터 구하기
select user_id, product_id
from online_sale
group by user_id, product_id
having count(product_id) >= 2
order by user_id asc, product_id desc;

