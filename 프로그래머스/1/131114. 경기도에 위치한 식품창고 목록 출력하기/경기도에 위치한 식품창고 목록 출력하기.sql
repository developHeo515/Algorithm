-- 코드를 입력하세요
SELECT warehouse_id, warehouse_name, address, NVL(freezer_yn, 'N')
from FOOD_WAREHOUSE
where address like '%경기도%'
order by warehouse_id