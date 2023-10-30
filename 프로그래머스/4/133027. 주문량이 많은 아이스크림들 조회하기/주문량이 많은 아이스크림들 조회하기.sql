select flavor
from (
    select flavor, rownum
    from (
        select flavor
        from (select * from first_half
            union
            select * from july)
        group by flavor
        order by sum(total_order) desc))
where rownum <= 3;