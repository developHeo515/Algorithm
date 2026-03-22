-- 코드를 입력하세요
SELECT count(user_id)
from USER_INFO
where to_char(JOINED, 'yyyy') = '2021'
and age >= 20
and age <= 29