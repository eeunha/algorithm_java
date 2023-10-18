-- 코드를 입력하세요
-- 코드를 입력하세요
SELECT 
    HISTORY_ID, 
    CAR_ID, 
    to_char(START_DATE, 'yyyy-mm-dd') as START_DATE, 
    to_char(END_DATE, 'yyyy-mm-dd') as END_DATE,
    case
        when (end_date - start_date) >= 29 then '장기 대여'
        else '단기 대여' 
    end as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between to_date('2022-09-01', 'yyyy-mm-dd') and to_date('2022-09-30', 'yyyy-mm-dd')
order by history_id desc;