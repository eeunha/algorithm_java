-- 코드를 입력하세요
SELECT distinct(c.car_id)
from CAR_RENTAL_COMPANY_CAR c
    inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        on c.car_id = h.car_id
where c.car_type = '세단' and to_char(h.start_date, 'yyyy-mm') = '2022-10'
order by c.car_id desc;