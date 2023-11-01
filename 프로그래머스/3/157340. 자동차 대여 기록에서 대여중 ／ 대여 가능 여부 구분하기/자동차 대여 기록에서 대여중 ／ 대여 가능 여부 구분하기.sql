-- 해당일에 대여중인 아이디
-- select car_id
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- where start_date <= to_date('2022-10-16', 'yyyy-mm-dd') and end_date >= to_date('2022-10-16', 'yyyy-mm-dd')
-- order by car_id asc;

select distinct car_id,
    case 
        when car_id in (select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where start_date <= to_date('2022-10-16', 'yyyy-mm-dd') and end_date >= to_date('2022-10-16', 'yyyy-mm-dd')) then '대여중'
        else '대여 가능'
    end as availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by car_id desc;