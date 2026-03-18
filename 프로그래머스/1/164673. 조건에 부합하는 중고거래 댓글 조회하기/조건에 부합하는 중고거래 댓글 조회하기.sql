-- 코드를 입력하세요
SELECT a.title, a.board_id, b.reply_id, b.writer_id, b.contents, to_char(b.created_date, 'yyyy-mm-dd')
from USED_GOODS_BOARD a
join USED_GOODS_REPLY b
on a.board_id = b.board_id
where a.created_date
between to_date('2022-10-01', 'yyyy-mm-dd')
and to_date('2022-10-31', 'yyyy-mm-dd')
order by b.created_date asc, a.title asc