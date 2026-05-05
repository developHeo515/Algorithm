-- 코드를 입력하세요
SELECT ANIMAL_ID, name
from ANIMAL_INS
where lower(name) like '%el%'
and ANIMAL_TYPE = 'Dog'
order by name