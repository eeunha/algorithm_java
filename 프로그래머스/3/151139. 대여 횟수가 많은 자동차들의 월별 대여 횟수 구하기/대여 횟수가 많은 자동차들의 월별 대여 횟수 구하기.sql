-- 테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차 Id
-- select car_id
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- where start_date between to_date('2022-08-01', 'yyyy-mm-dd') and to_date('2022-10-31', 'yyyy-mm-dd')
-- group by car_id
-- having count(*) >= 5;

--해당 기간 동안의 월별 
--자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트

-- select car_id,
--     to_number(to_char(start_date, 'mm')) as month
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- where start_date between to_date('2022-08-01', 'yyyy-mm-dd') and to_date('2022-10-31', 'yyyy-mm-dd') 
--     and car_id in (select car_id
--         from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
--         where start_date between to_date('2022-08-01', 'yyyy-mm-dd') and to_date('2022-10-31', 'yyyy-mm-dd')
--         group by car_id
--         having count(*) >= 5)


select 
    to_number(to_char(start_date, 'mm')) as month,
    car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between to_date('2022-08-01', 'yyyy-mm-dd') and to_date('2022-10-31', 'yyyy-mm-dd') 
    and car_id in (select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        where start_date between to_date('2022-08-01', 'yyyy-mm-dd') and to_date('2022-10-31', 'yyyy-mm-dd')
        group by car_id
        having count(*) >= 5)
group by to_number(to_char(start_date, 'mm')), car_id
order by month asc, car_id desc;