-- 코드를 입력하세요
-- USER_INFO - gender 0:남자 1:여자
-- ONLINE_SALE 
-- 동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재

-- 2021년 가입
-- 상품구매한 회원수
-- 상품 구매한 회원의 비율 = 상품구매한원수/가입한회원수
-- 년 월 별로 출력
-- 비율은 소수점 두자리에서 반올림
-- 년 오름차순, 월 오름차순 정렬

--2021년 가입한 사람 아이디
-- SELECT user_id
-- from user_info
-- where to_char(joined, 'yyyy') = '2021';

--2021년 가입한 사람 수
-- SELECT count(*)
-- from user_info
-- where to_char(joined, 'yyyy') = '2021';

-- 전체 조인한 테이블
-- select u.user_id, u.gender, u.age, u.joined, s.online_sale_id, s.product_id, s.sales_amount, s.sales_date 
-- from user_info u
--     inner join online_sale s
--     on u.user_id = s.user_id;

-- 2021년 가입한 사람 전체 테이블
-- select u.user_id, u.gender, u.age, u.joined, s.online_sale_id, s.product_id, s.sales_amount, s.sales_date 
-- from user_info u
--     inner join online_sale s
--     on u.user_id = s.user_id
-- where to_char(u.joined, 'yyyy') = '2021';

-- 2021년에 가입한 사람 중 구매한 사람 구매 내역 테이블
-- select *
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021');

-- 2021년 가입한 사람 테이블에 년, 월 열 추가
-- select online_sale_id, user_id, product_id, sales_amount, sales_date,
--     to_char(sales_date, 'yyyy') as year,
--     to_number(to_char(sales_date, 'mm')) as month
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021');

-- 해당 년월에 구매한 사람 수
-- select 
--     to_char(sales_date, 'yyyy') as year,
--     to_number(to_char(sales_date, 'mm')) as month,
--     count(*) as puchased_users
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021')
-- group by to_char(sales_date, 'yyyy'), to_number(to_char(sales_date, 'mm'));

-- select 
--     to_char(sales_date, 'yyyy') as year,
--     to_number(to_char(sales_date, 'mm')) as month,
--     count(*) as puchased_users,
--     to_char(round(count(*) / (SELECT count(*)
--     from user_info
--     where to_char(joined, 'yyyy') = '2021'), 1), '0.9') as puchased_ratio
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021')
-- group by to_char(sales_date, 'yyyy'), to_number(to_char(sales_date, 'mm'))
-- order by year asc, month asc;

-- 21년에 가입한 사람 중 구매내역이 있는 회원 아이디
-- select distinct user_id
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021')
-- order by user_id asc;

-- select 
--     to_char(sales_date, 'yyyy') as year,
--     to_number(to_char(sales_date, 'mm')) as month,
--     count(*) as puchased_users,
--     to_char(round(count(*) / (SELECT count(*)
--     from user_info
--     where to_char(joined, 'yyyy') = '2021'), 1), '0.9') as puchased_ratio
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021')
-- group by to_char(sales_date, 'yyyy'), to_number(to_char(sales_date, 'mm'))
-- order by year asc, month asc;

-- select distinct
--     to_char(sales_date, 'yyyy') as year,
--     to_number(to_char(sales_date, 'mm')) as month,
--     user_id
-- from online_sale
-- where user_id in (SELECT user_id
--         from user_info
--         where to_char(joined, 'yyyy') = '2021')
-- order by year asc, month asc, user_id asc;

select year, month, 
    count(*) as PUCHASED_USERS,
    round(count(*) / (SELECT count(*)
        from user_info
        where to_char(joined, 'yyyy') = '2021'), 1) as PUCHASED_RATIO
from (select distinct
        to_char(sales_date, 'yyyy') as year,
        to_number(to_char(sales_date, 'mm')) as month,
        user_id
    from online_sale
    where user_id in (SELECT user_id
            from user_info
            where to_char(joined, 'yyyy') = '2021'))
group by year, month
order by year asc, month asc;

