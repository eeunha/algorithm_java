-- 코드를 입력하세요
-- SELECT * from animal_outs;

-- 몇 시에 입양이 가장 활발하게 일어나는가
-- 9:00 ~ 19:59 시간대 별로 나누기
-- 입양 횟수 조회
-- 시간대 정렬

-- select animal_id, to_number(to_char(datetime, 'hh24')) as "hour"
-- from animal_outs
-- where to_number(to_char(datetime, 'hh24')) >= 9;

select to_number(to_char(datetime, 'hh24')) as "hour", count(*) as count
from animal_outs
group by to_number(to_char(datetime, 'hh24'))
having to_number(to_char(datetime, 'hh24')) between 9 and 19
order by "hour";

