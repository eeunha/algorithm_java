-- 코드를 입력하세요
select animal_id, name
from 
(select a.*, rownum
from 
    (SELECT i.animal_id, i.name, o.datetime - i.datetime
    from animal_ins i
            inner join animal_outs o
                on i.animal_id = o.animal_id
    order by o.datetime - i.datetime desc) a)
where rownum <= 2;