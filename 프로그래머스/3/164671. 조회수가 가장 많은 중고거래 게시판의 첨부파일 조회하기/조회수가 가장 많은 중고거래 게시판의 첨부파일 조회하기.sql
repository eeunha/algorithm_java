-- 코드를 입력하세요
-- SELECT 
--     '/home/grep/src/' || b.board_id || '/' || f.file_id || f.file_name || f.file_ext as "file_path"
-- from USED_GOODS_BOARD b
--     inner join USED_GOODS_FILE f
--     on b.board_id = f.board_id
-- order by f.file_id desc;

-- select b.board_id, sum(b.views)
-- from USED_GOODS_BOARD b
--     inner join USED_GOODS_FILE f
--     on b.board_id = f.board_id
-- group by b.board_id;

-- select *
-- from (select b.board_id, sum(b.views) as "sum"
--     from USED_GOODS_BOARD b
--         inner join USED_GOODS_FILE f
--         on b.board_id = f.board_id
--     group by b.board_id)
-- where sum = max(sum);

-- select "board_id"
-- from (select b.board_id as "board_id", sum(b.views) as "sum_views"
--     from USED_GOODS_BOARD b
--         inner join USED_GOODS_FILE f
--         on b.board_id = f.board_id
--     group by b.board_id)
-- having "sum_views" = max("sum_views");

-- SELECT 
--     '/home/grep/src/' || b.board_id || '/' || f.file_id || f.file_name || f.file_ext as "file_path"
-- from USED_GOODS_BOARD b
--     inner join USED_GOODS_FILE f
--     on b.board_id = f.board_id
-- order by f.file_id desc;


-- 파일 경로 만들기
-- '/home/grep/src/' || board_id || '/' || file_id || file_name || file_ext as "file_path"



-- select *
-- from USED_GOODS_BOARD;

-- 1. 게시글의 조회수가 가장 높은 글의 board_id 찾기
-- select board_id
-- from (select board_id, views, rank() over(order by views desc) as rank
--       from used_goods_board)
-- where rank = 1;

-- 2. 해당 board_id의 이미지 파일들 알기
-- select *
-- from used_goods_file
-- where board_id = (select board_id
-- from (select board_id, views, rank() over(order by views desc) as rank
--       from used_goods_board)
--     where rank = 1);

-- 3. 파일 경로로 표현하기
select '/home/grep/src/' || board_id || '/' || file_id || file_name || file_ext as "file_path"
from used_goods_file
where 
    board_id = (select board_id
        from (select board_id, views, rank() over(order by views desc) as rank
            from used_goods_board)
        where rank = 1)
order by file_id desc;