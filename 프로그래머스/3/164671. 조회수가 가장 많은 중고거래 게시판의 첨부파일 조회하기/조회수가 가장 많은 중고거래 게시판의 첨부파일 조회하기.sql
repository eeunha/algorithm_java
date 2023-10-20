-- 코드를 입력하세요

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
