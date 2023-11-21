-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회
--  시간대 순으로 정렬
-- select
--     to_number(to_char(datetime, 'hh24')) as hour, 
--     count(*)
-- from ANIMAL_OUTS
-- group by to_number(to_char(datetime, 'hh24'))
-- order by hour;

-- SELECT hours.hour as hour, count(*) as count
-- from (LEVEL - 1 AS hour
--         FROM dual
--         CONNECT BY LEVEL <= 24) hours
--     left outer join animal_outs o
--     on o.to_number(to_char(datetime, 'hh24')) = hours.hour;
    
SELECT
    hours.hour AS hour,
    COUNT(animal_outs.datetime) AS count
FROM
    (
        SELECT LEVEL - 1 AS hour
        FROM dual
        CONNECT BY LEVEL <= 24
    ) hours
LEFT JOIN ANIMAL_OUTS ON to_number(to_char(animal_outs.datetime, 'hh24')) = hours.hour
GROUP BY
    hours.hour
ORDER BY
    hours.hour;