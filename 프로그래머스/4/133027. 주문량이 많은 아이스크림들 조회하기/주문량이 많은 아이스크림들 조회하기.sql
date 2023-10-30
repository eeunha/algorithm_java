select flavor
from (
    select flavor, rownum
    from (
        select flavor, sum(total_order) as total_order
        from (select * from first_half
            union
            select * from july)
        group by flavor
        order by total_order desc))
where rownum <= 3;
