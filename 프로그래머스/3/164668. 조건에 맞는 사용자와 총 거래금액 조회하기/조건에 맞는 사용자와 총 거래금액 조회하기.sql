-- 코드를 입력하세요

select u.user_id, u.nickname, s.total_price    
from used_goods_user u
inner join (select writer_id, sum(price) as total_price
            from used_goods_board
            where status = 'DONE'
            group by writer_id
            having sum(price) >= 700000) s
on u.user_id = s.writer_id
order by s.total_price asc;


