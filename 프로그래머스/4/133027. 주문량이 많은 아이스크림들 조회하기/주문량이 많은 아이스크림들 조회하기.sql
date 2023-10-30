-- select flavor
-- from (
--     select flavor, rownum
--     from (
--         select flavor
--         from (select * from first_half
--             union
--             select * from july)
--         group by flavor
--         order by sum(total_order) desc))
-- where rownum <= 3;

select h.flavor
from first_half h, july j
where h.flavor = j.flavor
group by h.flavor
order by sum(h.total_order + j.total_order) desc
FETCH FIRST 3 ROWS ONLY;