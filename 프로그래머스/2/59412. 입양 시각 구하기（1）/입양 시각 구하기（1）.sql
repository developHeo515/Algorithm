-- 코드를 입력하세요
SELECT 
    TO_NUMBER(TO_CHAR(DATETIME, 'HH24')) AS HOUR,
    count(*) as COUNT
from ANIMAL_OUTS
where to_char(DATETIME, 'HH24') between '09' and '19'
group by TO_CHAR(DATETIME, 'HH24')
order by to_number(Hour)