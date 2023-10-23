-- 코드를 입력하세요
-- 리뷰를 가장 많이 작성한 회원의 리뷰 조회


-- 정렬은 작성일 오름차순, 리뷰텍스트 오름차순


-- 회원 아이디 별 리뷰 개수 세기
-- 리뷰 개수로 내림차순 정렬
-- select member_id, count(*)
-- from rest_review
-- group by member_id
-- having count(*) = (select max(count(*)) from rest_review group by member_id);

-- 해당 이름의 리뷰 읽기 - 회원이름, 리뷰텍스트, 리뷰작성일
-- select distinct(m.member_id)
-- from member_profile m
--     inner join rest_review r
--         on m.member_id = r.member_id
-- where m.member_id in (select member_id
--     from rest_review
--     group by member_id
--     having count(*) = (select max(count(*)) from rest_review group by member_id));
    
-- select member_id, count(*)
-- from rest_review
-- group by member_id
-- having count(*) = (select max(count(*)) from rest_review group by member_id);

select m.member_name, r.review_text, to_char(r.review_date, 'yyyy-mm-dd')
from member_profile m
    inner join rest_review r
        on m.member_id = r.member_id
where m.member_id in (select member_id
    from rest_review
    group by member_id
    having count(*) = (select max(count(*)) from rest_review group by member_id))
order by r.review_date asc, r.review_text asc;