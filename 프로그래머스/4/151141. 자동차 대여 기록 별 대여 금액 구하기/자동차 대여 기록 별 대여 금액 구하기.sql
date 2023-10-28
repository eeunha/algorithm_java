-- 트럭인 차의 아이디 구하기
-- 대여기록 별 의 총 대여 일자 구하기
-- 총 대여일자의 구간 짓기
-- 해당 차의 기본요금 구하기
-- 대여일자 구간 별 할인된 요금 계산하기
-- history_id, fee 출력하기
-- 결과는 대여 금액을 기준으로 내림차순 정렬, 대여 기록 ID를 기준으로 내림차순 정렬

-- 트럭인 차의 아이디 구하기
-- select c.car_id, c.daily_fee, h.history_id, h.end_date - h.start_date + 1 as "duration",
--     case
--         when  h.end_date - h.start_date + 1  >= 90 then '90일 이상'
--         when  h.end_date - h.start_date + 1  >= 30 then '30일 이상'
--         when  h.end_date - h.start_date + 1  >= 7 then '7일 이상'
--         else '7일 미만'
--     end as "duration_type"
-- from CAR_RENTAL_COMPANY_CAR c
--     inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
--     on c.car_id = h.car_id
-- where c.car_type = '트럭';

select a.history_id, 
    case
        when d.duration_type is null then a.daily_fee * a."duration"
        else (a.daily_fee * a."duration") * (1 - d.discount_rate / 100)
    end as "fee"
from (select car_type, duration_type, discount_rate 
      from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
      where car_type = '트럭') d
    right outer join (select c.car_id, c.daily_fee, h.history_id, h.end_date - h.start_date + 1 as "duration",
            case
                when  h.end_date - h.start_date + 1  >= 90 then '90일 이상'
                when  h.end_date - h.start_date + 1  >= 30 then '30일 이상'
                when  h.end_date - h.start_date + 1  >= 7 then '7일 이상'
                else '7일 미만'
            end as "duration_type"
        from CAR_RENTAL_COMPANY_CAR c
            inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
            on c.car_id = h.car_id
        where c.car_type = '트럭') a
    on d.duration_type = a."duration_type"
order by "fee" desc, a.history_id desc;