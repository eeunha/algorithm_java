-- 코드를 입력하세요
-- SELECT i.rest_id, i.rest_name, i.food_type, i.views, i.parking_lot, i.address, r.review_score
-- from rest_info i
--     inner join rest_review r
--         on i.rest_id = r.rest_id
-- where i.address like '서울%';

-- select rest_id, round(avg(review_score), 2)
-- from rest_review
-- group by rest_id

select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, r."score"
from rest_info i
    inner join (select rest_id, round(avg(review_score), 2) as "score"
    from rest_review
    group by rest_id) r
        on i.rest_id = r.rest_id
where i.address like '서울%'
order by r."score" desc, i.favorites desc;