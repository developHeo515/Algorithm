-- 코드를 입력하세요
SELECT 
    substr(PRODUCT_CODE, 1, 2) as CATEGORY
    , count(*)
from PRODUCT
group by CATEGORY
order by CATEGORY
