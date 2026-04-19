-- 코드를 작성해주세요
select round(AVG(
    CASE
        WHEN LENGTH is null then 10
        ELSE LENGTH
    END
), 2) as AVERAGE_LENGTH
from FISH_INFO