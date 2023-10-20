-- 코드를 입력하세요
select u.user_id, u.nickname, 
    u.city || ' ' || u.STREET_ADDRESS1 || ' ' || u.STREET_ADDRESS2 as "전체주소",
    substr(u.TLNO, 1, 3) || '-' || substr(u.TLNO, 4, 4) || '-' || substr(u.TLNO, 8) as "전화번호"
from 
    (SELECT writer_id
    from USED_GOODS_BOARD
    group by writer_id
    having count(writer_id) >= 3) a
    inner join USED_GOODS_USER u
        on a.writer_id = u.user_id
order by u.user_id desc;