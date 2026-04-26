-- 코드를 입력하세요
SELECT ANIMAL_ID, name, to_char(DATETIME, 'yyyy-mm-dd') as "날짜"
from ANIMAL_INS
order by ANIMAL_ID