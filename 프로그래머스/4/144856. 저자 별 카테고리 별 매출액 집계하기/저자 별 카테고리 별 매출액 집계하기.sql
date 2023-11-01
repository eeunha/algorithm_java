-- 2022년 1월의 판매 테이블
-- select *
-- from book_sales 
-- where to_char(sales_date, 'yyyy-mm') = '2022-01'

-- 책 & 저자 테이블
-- select *
-- from book b
--     inner join author a
--     on b.author_id = a.author_id;

-- 2022년 1월 책 아이디 별 판매량
-- select book_id, sum(sales) as sales
-- from book_sales 
-- where to_char(sales_date, 'yyyy-mm') = '2022-01'
-- group by book_id;

-- 책 & 저자 필요데이터 추출한 테이블
-- select b.author_id, a.author_name, b.book_id, b.category, b.price
-- from book b
--     inner join author a
--     on b.author_id = a.author_id;

-- 책 별 판매금액
-- select b.book_id, b.category, b.author_id, b.price, s.sales,
--     s.sales * b.price as total_price
-- from book b
--     inner join (select book_id, sum(sales) as sales
--         from book_sales 
--         where to_char(sales_date, 'yyyy-mm') = '2022-01'
--         group by book_id) s
--     on b.book_id = s.book_id;

select a.author_id, a.author_name, c.category, c.total_price 
from (select b.category, b.author_id,
            sum(s.sales * b.price) as total_price
        from book b
            inner join (select book_id, sum(sales) as sales
                    from book_sales 
                    where to_char(sales_date, 'yyyy-mm') = '2022-01'
                    group by book_id) s
            on b.book_id = s.book_id
        group by b.author_id, b.category) c
    inner join author a
    on c.author_id = a.author_id
order by author_id asc, category desc;