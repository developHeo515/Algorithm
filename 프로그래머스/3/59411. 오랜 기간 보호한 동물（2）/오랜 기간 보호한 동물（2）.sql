-- 코드를 입력하세요
SELECT O.ANIMAL_ID,
    O.name
from ANIMAL_OUTS O
join ANIMAL_INS I 
on O.animal_id = I.animal_id
order by O.DATETIME - I.DATETIME desc
fetch first 2 rows only