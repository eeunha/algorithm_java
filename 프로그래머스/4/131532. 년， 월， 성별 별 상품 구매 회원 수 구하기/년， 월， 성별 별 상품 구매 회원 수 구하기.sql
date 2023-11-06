-- 년, 월, 성별 별로 상품을 구매한 회원 수 집계하기
-- 년, 월, 성별 오름차순 정렬
-- 성별 없으면 제외

-- select 
--     to_char(s.sales_date, 'yyyy') as year,
--     to_number(to_char(s.sales_date, 'mm')) as month,
--     u.gender, count(*) as users
-- from user_info u
--     inner join online_sale s
--     on u.user_id = s.user_id
-- where u.gender is not null
-- group by to_char(s.sales_date, 'yyyy'), to_number(to_char(s.sales_date, 'mm')), gender
-- order by year, month, gender;

-- select year, month, gender, count(*) as users
-- from 
--     (select distinct
--         to_char(s.sales_date, 'yyyy') as year,
--         to_number(to_char(s.sales_date, 'mm')) as month,
--         u.gender as gender
--     from user_info u
--         inner join online_sale s
--         on u.user_id = s.user_id
--     where u.gender is not null)
-- group by year, month, gender
-- order by year, month, gender;

select year, month, gender, count(*) as users
from
    (select distinct
        to_char(s.sales_date, 'yyyy') as year,
        to_number(to_char(s.sales_date, 'mm')) as month,
        u.gender as gender,
        u.user_id as user_id
    from user_info u
        inner join online_sale s
        on u.user_id = s.user_id
    where u.gender is not null
    order by year, month, gender, user_id)
group by year, month, gender
order by year, month, gender;