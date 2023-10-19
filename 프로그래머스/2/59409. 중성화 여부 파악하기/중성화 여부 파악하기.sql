-- -- 코드를 입력하세요
-- SELECT animal_id, name, 
--     decode(SEX_UPON_INTAKE, '%Neutered%', 'O', '%Spayed%', 'X') as "중성화"
-- from ANIMAL_INS
-- order by animal_id;


SELECT animal_id, name, 
    case
        when SEX_UPON_INTAKE like '%Neutered%' or SEX_UPON_INTAKE like '%Spayed%' then 'O'
        else 'X'
    end as "중성화"
from ANIMAL_INS
order by animal_id;