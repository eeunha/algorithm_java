-- 코드를 입력하세요
SELECT animal_id, name 
from ANIMAL_INS
where lower(name) like '%el%' and animal_type = 'Dog'
order by name;