select c.car_id, c.car_type, (c.daily_fee * 30 * (1 - d.discount_rate / 100)) as fee
from CAR_RENTAL_COMPANY_CAR c
    inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
    on c.car_type = d.car_type
where c.car_id not in (select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where TO_CHAR(end_date, 'YYYY-MM-DD') > '2022-11-01') 
    and c.car_type in ('세단', 'SUV') 
    and d.duration_type = '30일 이상' 
    and ((c.daily_fee * 30 * (1 - d.discount_rate / 100)) >= 500000 and (c.daily_fee * 30 * (1 - d.discount_rate / 100) < 2000000))
order by fee desc, car_type asc, car_id desc;