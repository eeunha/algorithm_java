-- 코드를 입력하세요
-- SELECT 
--     * 
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- where
-- order by AVERAGE_DURATION, CAR_ID desc;

-- SELECT 
--     car_id, 
--     avg(end_date - start_date) as AVERAGE_DURATION
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- where avg(end_date - start_date) >= 7;

-- select round(avg(end_date - start_date), 1) from CAR_RENTAL_COMPANY_RENTAL_HISTORY;

select 
    car_id,
    round(avg(end_date - start_date + 1), 1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having round(avg(end_date - start_date + 1), 1) >= 7
order by round(avg(end_date - start_date + 1), 1) desc, car_id desc;