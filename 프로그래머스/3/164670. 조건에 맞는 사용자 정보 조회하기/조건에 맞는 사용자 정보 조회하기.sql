-- 코드를 입력하세요
select user_id, nickname, 
    city || ' ' || STREET_ADDRESS1 || ' ' || STREET_ADDRESS2 as "전체주소",
    substr(TLNO, 1, 3) || '-' || substr(TLNO, 4, 4) || '-' || substr(TLNO, 8) as "전화번호"
from USED_GOODS_USER 
where user_id in 
    (SELECT writer_id
    from USED_GOODS_BOARD
    group by writer_id
    having count(writer_id) >= 3)
order by user_id desc;