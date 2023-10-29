-- select p.product_id, p.product_name, 
-- from food_product p
--     inner join food_order o
--     on p.product_id = o.product_id
-- where to_char(o.PRODUCE_DATE, 'yyyy-mm') = '2022-05';

select p.product_id, p.product_name, price * amount as total_sales
from food_product p
    inner join (select product_id, sum(amount) as amount
        from food_order
        where to_char(produce_date, 'yyyy-mm') = '2022-05'
        group by product_id) o
    on p.product_id = o.product_id
order by total_sales desc, p.product_id asc;