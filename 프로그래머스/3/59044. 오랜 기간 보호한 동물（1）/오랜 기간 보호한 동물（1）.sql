-- 코드를 입력하세요
select name, datetime
from (select i.name, i.datetime, rank() over(order by i.datetime) as "rnum"
    from animal_ins i
        left outer join animal_outs o
            on i.animal_id = o.animal_id
    where o.animal_id is null)
where "rnum" <= 3;