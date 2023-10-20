-- 코드를 입력하세요

-- 1. 두 번 이상 쓰인 이름 찾기
-- 2. 해당 이름이 쓰인 횟수 조회
-- 단, 이름이 없는 동물은 집계에서 제외
-- 3. 이름순

select name, count(name)
from animal_ins
where name is not null
group by name
having count(name) >= 2
order by name;