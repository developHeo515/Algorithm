-- 코드를 작성해주세요
select I.ITEM_ID, I.ITEM_NAME, I.RARITY
from ITEM_INFO I
join ITEM_TREE T
    on I.ITEM_ID = T.ITEM_ID
join ITEM_INFO P
    on T.PARENT_ITEM_ID = P.ITEM_ID
where P.RARITY = 'RARE'
order by I.ITEM_ID desc