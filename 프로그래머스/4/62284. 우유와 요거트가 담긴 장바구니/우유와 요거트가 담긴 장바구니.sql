-- select *
-- from CART_PRODUCTS
-- where name in ('Milk', 'Yogurt')
-- order by cart_id;

-- 우유가 담긴 장바구니 아이디
-- select cart_id
-- from CART_PRODUCTS
-- where name = 'Milk'
-- order by cart_id;

--우유와 요거트가 담긴 장바구니 아이디
select distinct cart_id
from CART_PRODUCTS
where cart_id in (select cart_id
        from CART_PRODUCTS
        where name = 'Milk')
    and name = 'Yogurt'
order by cart_id;
    
